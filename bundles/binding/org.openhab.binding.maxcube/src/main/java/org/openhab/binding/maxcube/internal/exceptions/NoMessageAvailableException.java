/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.maxcube.internal.exceptions;

/**
 * Will be thrown when there is an attempt to pull a message from the message processor,
 * but the processor does not yet have a complete message.
 * 
 * @author Christian Rockrohr <christian@rockrohr.de>
 */
public class NoMessageAvailableException extends Exception {

    private static final long serialVersionUID = -3473605698911634158L;

}
