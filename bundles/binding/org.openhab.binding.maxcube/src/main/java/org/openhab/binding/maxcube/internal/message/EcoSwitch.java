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
package org.openhab.binding.maxcube.internal.message;

/**
 * MAX!Cube EcoSwitch.
 * 
 * @author Marcel Verpaalen
 * @since 1.6.0
 */

public class EcoSwitch extends ShutterContact {

    /**
     * Class constructor.
     * 
     * @param c
     */
    public EcoSwitch(Configuration c) {
        super(c);
    }

    @Override
    public DeviceType getType() {
        // TODO Auto-generated method stub
        return DeviceType.EcoSwitch;
    }

}
