// **********************************************************************
//
// Copyright (c) 2003-2009 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

namespace IceInternal
{

    using System;
    using System.Collections.Generic;
    using System.Diagnostics;
    using System.Net;
    using System.Net.Sockets;
    using System.Text;

    class TcpAcceptor : Acceptor
    {
        public virtual void close()
        {
            Socket fd;
            lock(this)
            {
                fd = _fd;
                _fd = null;
            }
            if(fd != null)
            {
                if(_traceLevels.network >= 1)
                {
                    string s = "stopping to accept tcp connections at " + ToString();
                    _logger.trace(_traceLevels.networkCat, s);
                }

                try
                {
                    fd.Close();
                }
                catch(System.Exception)
                {
                    // Ignore.
                }
            }
        }

        public virtual void listen()
        {
            Network.doListen(_fd, _backlog);

            if(_traceLevels.network >= 1)
            {
                StringBuilder s = new StringBuilder("accepting tcp connections at ");
		s.Append(ToString());
                if(_traceLevels.network >= 3)
                {
                    List<string> interfaces =
                        Network.getHostsForEndpointExpand(_addr.Address.ToString(), instance_.protocolSupport(), true);
                    if(interfaces.Count != 0)
                    {
                        s.Append("\nlocal interfaces: ");
                        bool first = true;
                        foreach(string iface in interfaces)
                        {
                            if(!first)
                            {
                                s.Append(", ");
                            }
                            s.Append(iface);
                            first = false;
                        }
                    }
                }
                _logger.trace(_traceLevels.networkCat, s.ToString());
            }
        }

        public virtual IAsyncResult beginAccept(AsyncCallback callback, object state)
        {
            try
            {
                return _fd.BeginAccept(callback, state);
            }
            catch(SocketException ex)
            {
                throw new Ice.SocketException(ex);
            }
        }

        public virtual Transceiver endAccept(IAsyncResult result)
        {
            Socket fd = null;
            try
            {
                fd = _fd.EndAccept(result);
            }
            catch(SocketException ex)
            {
                throw new Ice.SocketException(ex);
            }

            Network.setBlock(fd, false);
            Network.setTcpBufSize(fd, instance_.initializationData().properties, _logger);

            if(_traceLevels.network >= 1)
            {
                string s = "accepted tcp connection\n" + Network.fdToString(fd);
                _logger.trace(_traceLevels.networkCat, s);
            }

            return new TcpTransceiver(instance_, fd, null, true);
        }

        public override string ToString()
        {
            return Network.addrToString(_addr);
        }

        internal int effectivePort()
        {
            return _addr.Port;
        }

        internal TcpAcceptor(Instance instance, string host, int port)
        {
            instance_ = instance;
            _traceLevels = instance.traceLevels();
            _logger = instance.initializationData().logger;
            _backlog = instance.initializationData().properties.getPropertyAsIntWithDefault("Ice.TCP.Backlog", 511);

            try
            {
                _addr = Network.getAddressForServer(host, port, instance_.protocolSupport());
                _fd = Network.createSocket(false, _addr.AddressFamily);
                Network.setBlock(_fd, false);
                Network.setTcpBufSize(_fd, instance_.initializationData().properties, _logger);
                if(AssemblyUtil.platform_ != AssemblyUtil.Platform.Windows)
                {
                    //
                    // Enable SO_REUSEADDR on Unix platforms to allow
                    // re-using the socket even if it's in the TIME_WAIT
                    // state. On Windows, this doesn't appear to be
                    // necessary and enabling SO_REUSEADDR would actually
                    // not be a good thing since it allows a second
                    // process to bind to an address even it's already
                    // bound by another process.
                    //
                    // TODO: using SO_EXCLUSIVEADDRUSE on Windows would
                    // probably be better but it's only supported by recent
                    // Windows versions (XP SP2, Windows Server 2003).
                    //
                    Network.setReuseAddress(_fd, true);
                }
                if(_traceLevels.network >= 2)
                {
                    string s = "attempting to bind to tcp socket " + ToString();
                    _logger.trace(_traceLevels.networkCat, s);
                }
                _addr = Network.doBind(_fd, _addr);
            }
            catch(System.Exception)
            {
                _fd = null;
                throw;
            }
        }

        private Instance instance_;
        private TraceLevels _traceLevels;
        private Ice.Logger _logger;
        private Socket _fd;
        private int _backlog;
        private IPEndPoint _addr;
    }

}
