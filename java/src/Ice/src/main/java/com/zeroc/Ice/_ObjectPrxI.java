// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

package com.zeroc.Ice;

import java.util.LinkedList;
import java.util.List;

import com.zeroc.IceInternal.OutgoingAsync;

/**
 * Concrete proxy implementation.
 **/
public class _ObjectPrxI implements ObjectPrx, java.io.Serializable
{
    public Communicator ice_getCommunicator()
    {
        return _reference.getCommunicator();
    }

    public boolean ice_isA(String id)
    {
        return ice_isA(id, ObjectPrx.noExplicitContext);
    }

    public boolean ice_isA(String id, java.util.Map<String, String> __ctx)
    {
        return __ice_isAAsync(id, __ctx, true).__wait();
    }

    public java.util.concurrent.CompletableFuture<java.lang.Boolean> ice_isAAsync(String id)
    {
        return __ice_isAAsync(id, ObjectPrx.noExplicitContext, false);
    }

    public java.util.concurrent.CompletableFuture<java.lang.Boolean> ice_isAAsync(
        String id,
        java.util.Map<String, String> __ctx)
    {
        return __ice_isAAsync(id, __ctx, false);
    }

    private OutgoingAsync<java.lang.Boolean> __ice_isAAsync(
        String id,
        java.util.Map<String, String> __ctx,
        boolean __sync)
    {
        OutgoingAsync<java.lang.Boolean> __f =
            new OutgoingAsync<>(this, "ice_isA", OperationMode.Nonmutating, __sync, null);
        __f.invoke(true, __ctx, null, __os -> {
                       __os.writeString(id);
                   }, __is -> {
                       boolean __ret;
                       __ret = __is.readBool();
                       return __ret;
                   });
        return __f;
    }

    public void ice_ping()
    {
        ice_ping(ObjectPrx.noExplicitContext);
    }

    public void ice_ping(java.util.Map<String, String> __ctx)
    {
        __ice_pingAsync(__ctx, true).__wait();
    }

    public java.util.concurrent.CompletableFuture<Void> ice_pingAsync()
    {
        return __ice_pingAsync(ObjectPrx.noExplicitContext, false);
    }

    public java.util.concurrent.CompletableFuture<Void> ice_pingAsync(java.util.Map<String, String> __ctx)
    {
        return __ice_pingAsync(__ctx, false);
    }

    private OutgoingAsync<Void> __ice_pingAsync(
        java.util.Map<String, String> __ctx,
        boolean __sync)
    {
        OutgoingAsync<Void> __f = new OutgoingAsync<>(this, "ice_ping", OperationMode.Nonmutating, __sync, null);
        __f.invoke(false, __ctx, null, null, null);
        return __f;
    }

    public String[] ice_ids()
    {
        return ice_ids(ObjectPrx.noExplicitContext);
    }

    public String[] ice_ids(java.util.Map<String, String> __ctx)
    {
        return __ice_idsAsync(__ctx, true).__wait();
    }

    public java.util.concurrent.CompletableFuture<String[]> ice_idsAsync()
    {
        return __ice_idsAsync(ObjectPrx.noExplicitContext, false);
    }

    public java.util.concurrent.CompletableFuture<String[]> ice_idsAsync(java.util.Map<String, String> __ctx)
    {
        return __ice_idsAsync(__ctx, false);
    }

    private OutgoingAsync<String[]> __ice_idsAsync(
        java.util.Map<String, String> __ctx,
        boolean __sync)
    {
        OutgoingAsync<String[]> __f =
            new OutgoingAsync<>(this, "ice_ids", OperationMode.Nonmutating, __sync, null);
        __f.invoke(true, __ctx, null, null, __is -> {
                       String[] __ret;
                       __ret = StringSeqHelper.read(__is);
                       return __ret;
                   });
        return __f;
    }

    public String ice_id()
    {
        return ice_id(ObjectPrx.noExplicitContext);
    }

    public String ice_id(java.util.Map<String, String> __ctx)
    {
        return __ice_idAsync(__ctx, true).__wait();
    }

    public java.util.concurrent.CompletableFuture<java.lang.String> ice_idAsync()
    {
        return __ice_idAsync(ObjectPrx.noExplicitContext, false);
    }

    public java.util.concurrent.CompletableFuture<java.lang.String> ice_idAsync(java.util.Map<String, String> __ctx)
    {
        return __ice_idAsync(__ctx, false);
    }

    private OutgoingAsync<java.lang.String> __ice_idAsync(
        java.util.Map<String, String> __ctx,
        boolean __sync)
    {
        OutgoingAsync<java.lang.String> __f =
            new OutgoingAsync<>(this, "ice_id", OperationMode.Nonmutating, __sync, null);
        __f.invoke(true, __ctx, null, null, __is -> {
                       String __ret;
                       __ret = __is.readString();
                       return __ret;
                   });
        return __f;
    }

    public com.zeroc.Ice.Object.Ice_invokeResult ice_invoke(String operation, OperationMode mode, byte[] inParams)
    {
        return ice_invoke(operation, mode, inParams, ObjectPrx.noExplicitContext);
    }

    public com.zeroc.Ice.Object.Ice_invokeResult ice_invoke(String operation, OperationMode mode, byte[] inParams,
                                                            java.util.Map<String, String> __context)
    {
        return __ice_invokeAsync(operation, mode, inParams, __context, true).__wait();
    }

    public java.util.concurrent.CompletableFuture<com.zeroc.Ice.Object.Ice_invokeResult> ice_invokeAsync(
        String operation,
        OperationMode mode,
        byte[] inParams)
    {
        return ice_invokeAsync(operation, mode, inParams, ObjectPrx.noExplicitContext);
    }

    public java.util.concurrent.CompletableFuture<com.zeroc.Ice.Object.Ice_invokeResult> ice_invokeAsync(
        String operation,
        OperationMode mode,
        byte[] inParams,
        java.util.Map<String, String> __context)
    {
        return __ice_invokeAsync(operation, mode, inParams, __context, false);
    }

    private com.zeroc.IceInternal.ProxyIceInvoke __ice_invokeAsync(
        String operation,
        OperationMode mode,
        byte[] inParams,
        java.util.Map<String, String> __context,
        boolean __sync)
    {
        com.zeroc.IceInternal.ProxyIceInvoke __f =
            new com.zeroc.IceInternal.ProxyIceInvoke(this, operation, mode, __sync);
        __f.invoke(inParams, __context);
        return __f;
    }

    public Identity ice_getIdentity()
    {
        return _reference.getIdentity().clone();
    }

    public ObjectPrx ice_identity(Identity newIdentity)
    {
        if(newIdentity.name == null || newIdentity.name.equals(""))
        {
            throw new IllegalIdentityException();
        }
        if(newIdentity.equals(_reference.getIdentity()))
        {
            return this;
        }
        else
        {
            _ObjectPrxI proxy = new _ObjectPrxI();
            proxy.__setup(_reference.changeIdentity(newIdentity));
            return proxy;
        }
    }

    public java.util.Map<String, String> ice_getContext()
    {
        return new java.util.HashMap<>(_reference.getContext());
    }

    public String ice_getFacet()
    {
        return _reference.getFacet();
    }

    public ObjectPrx ice_facet(String newFacet)
    {
        if(newFacet == null)
        {
            newFacet = "";
        }

        if(newFacet.equals(_reference.getFacet()))
        {
            return this;
        }
        else
        {
            _ObjectPrxI proxy = new _ObjectPrxI();
            proxy.__setup(_reference.changeFacet(newFacet));
            return proxy;
        }
    }

    public String ice_getAdapterId()
    {
        return _reference.getAdapterId();
    }

    public Endpoint[] ice_getEndpoints()
    {
        return _reference.getEndpoints().clone();
    }

    public int ice_getLocatorCacheTimeout()
    {
        return _reference.getLocatorCacheTimeout();
    }

    public int ice_getInvocationTimeout()
    {
        return _reference.getInvocationTimeout();
    }

    public String ice_getConnectionId()
    {
        return _reference.getConnectionId();
    }

    public boolean ice_isConnectionCached()
    {
        return _reference.getCacheConnection();
    }

    public EndpointSelectionType ice_getEndpointSelection()
    {
        return _reference.getEndpointSelection();
    }

    public boolean ice_isSecure()
    {
        return _reference.getSecure();
    }

    public EncodingVersion ice_getEncodingVersion()
    {
        return _reference.getEncoding().clone();
    }

    public boolean ice_isPreferSecure()
    {
        return _reference.getPreferSecure();
    }

    public RouterPrx ice_getRouter()
    {
        com.zeroc.IceInternal.RouterInfo ri = _reference.getRouterInfo();
        return ri != null ? ri.getRouter() : null;
    }

    public LocatorPrx ice_getLocator()
    {
        com.zeroc.IceInternal.LocatorInfo ri = _reference.getLocatorInfo();
        return ri != null ? ri.getLocator() : null;
    }

    public boolean ice_isCollocationOptimized()
    {
        return _reference.getCollocationOptimized();
    }

    public boolean ice_isTwoway()
    {
        return _reference.getMode() == com.zeroc.IceInternal.Reference.ModeTwoway;
    }

    public boolean ice_isOneway()
    {
        return _reference.getMode() == com.zeroc.IceInternal.Reference.ModeOneway;
    }

    public boolean ice_isBatchOneway()
    {
        return _reference.getMode() == com.zeroc.IceInternal.Reference.ModeBatchOneway;
    }

    public boolean ice_isDatagram()
    {
        return _reference.getMode() == com.zeroc.IceInternal.Reference.ModeDatagram;
    }

    public boolean ice_isBatchDatagram()
    {
        return _reference.getMode() == com.zeroc.IceInternal.Reference.ModeBatchDatagram;
    }

    public Connection ice_getConnection()
    {
        return __ice_getConnectionAsync().__wait();
    }

    public java.util.concurrent.CompletableFuture<Connection> ice_getConnectionAsync()
    {
        return __ice_getConnectionAsync();
    }

    private com.zeroc.IceInternal.ProxyGetConnection __ice_getConnectionAsync()
    {
        com.zeroc.IceInternal.ProxyGetConnection r = new com.zeroc.IceInternal.ProxyGetConnection(this);
        r.invoke();
        return r;
    }

    public Connection ice_getCachedConnection()
    {
        com.zeroc.IceInternal.RequestHandler handler = null;
        synchronized(this)
        {
            handler = _requestHandler;
        }

        if(handler != null)
        {
            try
            {
                return handler.getConnection();
            }
            catch(LocalException ex)
            {
            }
        }
        return null;
    }

    public void ice_flushBatchRequests()
    {
        __ice_flushBatchRequestsAsync().__wait();
    }

    public java.util.concurrent.CompletableFuture<Void> ice_flushBatchRequestsAsync()
    {
        return __ice_flushBatchRequestsAsync();
    }

    private com.zeroc.IceInternal.ProxyFlushBatch __ice_flushBatchRequestsAsync()
    {
        com.zeroc.IceInternal.ProxyFlushBatch __f = new com.zeroc.IceInternal.ProxyFlushBatch(this);
        try
        {
            __f.invoke();
        }
        catch(Exception ex)
        {
            __f.abort(ex);
        }
        return __f;
    }

    @Override
    public boolean equals(java.lang.Object r)
    {
        if(this == r)
        {
            return true;
        }

        if(r instanceof _ObjectPrxI)
        {
            return _reference.equals(((_ObjectPrxI)r)._reference);
        }

        return false;
    }

    @Override
    public final int hashCode()
    {
        return _reference.hashCode();
    }

    @Override
    public final String toString()
    {
        return _reference.toString();
    }

    @Override
    public void __write(OutputStream os)
    {
        _reference.getIdentity().ice_write(os);
        _reference.streamWrite(os);
    }

    @Override
    public void __copyFrom(ObjectPrx p)
    {
        synchronized(p)
        {
            _ObjectPrxI h = (_ObjectPrxI)p;
            _reference = h._reference;
            _requestHandler = h._requestHandler;
        }
    }

    @Override
    public com.zeroc.IceInternal.Reference __reference()
    {
        return _reference;
    }

    @Override
    public ObjectPrx __newInstance(com.zeroc.IceInternal.Reference ref)
    {
        try
        {
            _ObjectPrxI proxy = getClass().newInstance();
            proxy.__setup(ref);
            return proxy;
        }
        catch(InstantiationException e)
        {
            //
            // Impossible
            //
            assert false;
            return null;
        }
        catch(IllegalAccessException e)
        {
            //
            // Impossible
            //
            assert false;
            return null;
        }
    }

    public StreamPair __getCachedMessageBuffers()
    {
        synchronized(this)
        {
            if(_streamCache != null && !_streamCache.isEmpty())
            {
                return _streamCache.remove(0);
            }
        }
        return null;
    }

    public void __cacheMessageBuffers(InputStream is, OutputStream os)
    {
        synchronized(this)
        {
            if(_streamCache == null)
            {
                _streamCache = new LinkedList<>();
            }
            _streamCache.add(new StreamPair(is, os));
        }
    }

    public int __handleException(Exception ex, com.zeroc.IceInternal.RequestHandler handler, OperationMode mode,
                                 boolean sent, com.zeroc.IceInternal.Holder<Integer> interval, int cnt)
    {
        __updateRequestHandler(handler, null); // Clear the request handler

        //
        // We only retry local exception, system exceptions aren't retried.
        //
        // A CloseConnectionException indicates graceful server shutdown, and is therefore
        // always repeatable without violating "at-most-once". That's because by sending a
        // close connection message, the server guarantees that all outstanding requests
        // can safely be repeated.
        //
        // An ObjectNotExistException can always be retried as well without violating
        // "at-most-once" (see the implementation of the checkRetryAfterException method
        //  of the ProxyFactory class for the reasons why it can be useful).
        //
        // If the request didn't get sent or if it's non-mutating or idempotent it can
        // also always be retried if the retry count isn't reached.
        //
        if(ex instanceof LocalException && (!sent ||
                                            mode == OperationMode.Nonmutating || mode == OperationMode.Idempotent ||
                                            ex instanceof CloseConnectionException ||
                                            ex instanceof ObjectNotExistException))
        {
            try
            {
                return _reference.getInstance().proxyFactory().checkRetryAfterException((LocalException)ex,
                                                                                        _reference,
                                                                                        interval,
                                                                                        cnt);
            }
            catch(CommunicatorDestroyedException exc)
            {
                //
                // The communicator is already destroyed, so we cannot retry.
                //
                throw ex;
            }
        }
        else
        {
            throw ex; // Retry could break at-most-once semantics, don't retry.
        }
    }

    public com.zeroc.IceInternal.RequestHandler __getRequestHandler()
    {
        if(_reference.getCacheConnection())
        {
            synchronized(this)
            {
                if(_requestHandler != null)
                {
                    return _requestHandler;
                }
            }
        }
        return _reference.getRequestHandler(this);
    }

    synchronized public com.zeroc.IceInternal.BatchRequestQueue __getBatchRequestQueue()
    {
        if(_batchRequestQueue == null)
        {
            _batchRequestQueue = _reference.getBatchRequestQueue();
        }
        return _batchRequestQueue;
    }

    public com.zeroc.IceInternal.RequestHandler __setRequestHandler(com.zeroc.IceInternal.RequestHandler handler)
    {
        if(_reference.getCacheConnection())
        {
            synchronized(this)
            {
                if(_requestHandler == null)
                {
                    _requestHandler = handler;
                }
                return _requestHandler;
            }
        }
        return handler;
    }

    public void __updateRequestHandler(com.zeroc.IceInternal.RequestHandler previous,
                                       com.zeroc.IceInternal.RequestHandler handler)
    {
        if(_reference.getCacheConnection() && previous != null)
        {
            synchronized(this)
            {
                if(_requestHandler != null && _requestHandler != handler)
                {
                    //
                    // Update the request handler only if "previous" is the same
                    // as the current request handler. This is called after
                    // connection binding by the connect request handler. We only
                    // replace the request handler if the current handler is the
                    // connect request handler.
                    //
                    _requestHandler = _requestHandler.update(previous, handler);
                }
            }
        }
    }

    //
    // Only for use by ProxyFactory
    //
    public void __setup(com.zeroc.IceInternal.Reference ref)
    {
        //
        // No need to synchronize, as this operation is only called
        // upon initial initialization.
        //

        assert(_reference == null);
        assert(_requestHandler == null);

        _reference = ref;
    }

    private void writeObject(java.io.ObjectOutputStream out)
        throws java.io.IOException
    {
        out.writeUTF(toString());
    }

    private void readObject(java.io.ObjectInputStream in)
         throws java.io.IOException, ClassNotFoundException
    {
        String s = in.readUTF();
        try
        {
            Communicator communicator = ((com.zeroc.Ice.ObjectInputStream)in).getCommunicator();
            if(communicator == null)
            {
                throw new java.io.IOException("Cannot deserialize proxy: no communicator provided");
            }
            _ObjectPrxI proxy = (_ObjectPrxI)communicator.stringToProxy(s);
            _reference = proxy._reference;
            assert(proxy._requestHandler == null);
        }
        catch(ClassCastException ex)
        {
            java.io.IOException e =
                new java.io.IOException("Cannot deserialize proxy: com.zeroc.Ice.ObjectInputStream not found");
            e.initCause(ex);
            throw e;
        }
        catch(LocalException ex)
        {
            java.io.IOException e = new java.io.IOException("Failure occurred while deserializing proxy");
            e.initCause(ex);
            throw e;
        }
    }

    public static class StreamPair
    {
        StreamPair(InputStream is, OutputStream os)
        {
            this.is = is;
            this.os = os;
        }

        public InputStream is;
        public OutputStream os;
    }

    protected transient com.zeroc.IceInternal.Reference _reference;
    private transient com.zeroc.IceInternal.RequestHandler _requestHandler;
    private transient com.zeroc.IceInternal.BatchRequestQueue _batchRequestQueue;
    private transient List<StreamPair> _streamCache;
    public static final long serialVersionUID = 0L;
}
