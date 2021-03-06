package com.rainbow.kam.ble_gatt_manager.legacy.manager.rx;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;

import com.rainbow.kam.ble_gatt_manager.exceptions.gatt.GattConnectException;
import com.rainbow.kam.ble_gatt_manager.model.BleDevice;
import com.rainbow.kam.ble_gatt_manager.legacy.model.GattObserveData;

import java.util.List;
import java.util.UUID;

import rx.Observable;

/**
 * Created by Kang Young Won on 2016-06-10.
 */
public interface IGattManager {
    BluetoothGatt getGatt();

    BleDevice getBleDevice();

    Observable<Boolean> observeConnection();

    Observable<Boolean> observeConnection(final BleDevice bleDevice);

    boolean isConnected();

    void disconnect();

    BluetoothGattCharacteristic findCharacteristic(final UUID uuid);

    Observable<BluetoothDevice> observeBond() throws GattConnectException;

    Observable<Integer> observeRssi(long rssiUpdateTimeInterval);

    Observable<List<BluetoothGattService>> observeDiscoverService();

    Observable<BluetoothGattCharacteristic> observeBattery();

    Observable<BluetoothGattCharacteristic> observeRead(final UUID uuidToRead);

    Observable<BluetoothGattCharacteristic> observeRead(final BluetoothGattCharacteristic characteristicToRead);

    Observable<GattObserveData> observeWrite(final UUID uuidToWrite, final List<Byte> valuesToWrite);

    Observable<GattObserveData> observeWrite(final UUID uuidToWrite, final byte[] valuesToWrite);

    Observable<GattObserveData> observeWrite(final BluetoothGattCharacteristic characteristicToWrite,
                                             final List<Byte> valuesToWrite);

    Observable<GattObserveData> observeWrite(final BluetoothGattCharacteristic characteristicToWrite,
                                             final byte[] valuesToWrite);

    Observable<GattObserveData> observeNotification(final UUID uuidToNotification,
                                                    final boolean enableNotification);


    Observable<GattObserveData> observeNotification(final BluetoothGattCharacteristic characteristicToNotification,
                                                    final boolean enableNotification);

    Boolean isNotificationEnabled(final BluetoothGattCharacteristic characteristic);

    Observable<GattObserveData> observeIndication(final UUID uuidToIndication);


    Observable<GattObserveData> observeIndication(final BluetoothGattCharacteristic characteristicToIndication);

    Boolean isIndicationEnabled(final BluetoothGattCharacteristic characteristic);
}