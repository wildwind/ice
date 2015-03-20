#!/usr/bin/env python
# **********************************************************************
#
# Copyright (c) 2003-2015 ZeroC, Inc. All rights reserved.
#
# This copy of Ice is licensed to you under the terms described in the
# ICE_LICENSE file included in this distribution.
#
# **********************************************************************

import sys

def run(client, server):
    sys.stdout.write("testing... ")
    sys.stdout.flush()

    client.sendline('t')
    server.expect('initiating callback')
    client.expect('received callback')

    client.sendline('t')
    server.expect('initiating callback')
    client.expect('received callback')

    print("ok")

    client.sendline('s')
    server.waitTestSuccess()

    client.sendline('x')
    client.waitTestSuccess()