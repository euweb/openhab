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
package org.openhab.binding.frontiersiliconradio.internal;

import org.openhab.binding.frontiersiliconradio.FrontierSiliconRadioBindingProvider;
import org.openhab.core.binding.BindingConfig;
import org.openhab.core.items.Item;
import org.openhab.model.item.binding.AbstractGenericBindingProvider;
import org.openhab.model.item.binding.BindingConfigParseException;

/**
 * This class is responsible for parsing the binding configuration.
 *
 * @author Rainer Ostendorf
 * @since 1.7.0
 */
public class FrontierSiliconRadioGenericBindingProvider extends AbstractGenericBindingProvider
        implements FrontierSiliconRadioBindingProvider {

    @Override
    public String getBindingType() {
        return "frontiersiliconradio";
    }

    @Override
    public String getProperty(String itemName) {
        FrontierSiliconRadioBindingConfig config = (FrontierSiliconRadioBindingConfig) bindingConfigs.get(itemName);
        return config != null ? config.property : null;
    }

    @Override
    public String getDeviceID(String itemName) {
        FrontierSiliconRadioBindingConfig config = (FrontierSiliconRadioBindingConfig) bindingConfigs.get(itemName);
        return config != null ? config.deviceId : null;
    }

    @Override
    public void validateItemType(Item item, String bindingConfig) throws BindingConfigParseException {
        // no need to validate anything here...
    }

    @Override
    public void processBindingConfiguration(String context, Item item, String bindingConfig)
            throws BindingConfigParseException {
        super.processBindingConfiguration(context, item, bindingConfig);

        final String[] configParts = bindingConfig.trim().split(":");
        if (configParts.length != 2) {
            throw new BindingConfigParseException(
                    "FrontierSiliconRadio configuration must contain of two parts separated by a ':'");
        }

        final String deviceId = configParts[0];
        final String property = configParts[1];
        final Class<? extends Item> itemType = item.getClass();
        final FrontierSiliconRadioBindingConfig config = new FrontierSiliconRadioBindingConfig(deviceId, property,
                itemType);

        addBindingConfig(item, config);
    }

    @Override
    public Class<? extends Item> getItemType(String itemName) {
        FrontierSiliconRadioBindingConfig config = (FrontierSiliconRadioBindingConfig) bindingConfigs.get(itemName);
        return config != null ? config.itemType : null;
    }

    private class FrontierSiliconRadioBindingConfig implements BindingConfig {

        /** device id, identifying the radio, e.g. "RadioSleepingroom" */
        final String deviceId;

        /** Parameter, e.g. "Power", "Mute" or "Volume" */
        final String property;

        /** item type */
        final Class<? extends Item> itemType;

        FrontierSiliconRadioBindingConfig(String deviceId, String property, Class<? extends Item> itemType) {
            this.deviceId = deviceId;
            this.property = property;
            this.itemType = itemType;
        }
    }
}
