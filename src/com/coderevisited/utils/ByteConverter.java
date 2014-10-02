package com.coderevisited.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteConverter
{
    public static void main(String[] args)
    {
        int i = 3453;
        byte[] bytesBigEndian = convertToBytes(i, ByteOrder.BIG_ENDIAN);
        int result = constructIntFromByteArray(bytesBigEndian, ByteOrder.BIG_ENDIAN);
        System.out.println(result);

        byte[] bytesLittleEndian = convertToBytes(i, ByteOrder.LITTLE_ENDIAN);
        result = constructIntFromByteArray(bytesLittleEndian, ByteOrder.LITTLE_ENDIAN);
        System.out.println(result);

        bytesBigEndian = convertToBytesUsingByteBuffer(i, ByteOrder.BIG_ENDIAN);
        result = constructIntFromByteArrayUsingByteBuffer(bytesBigEndian, ByteOrder.BIG_ENDIAN);
        System.out.println(result);

        bytesLittleEndian = convertToBytesUsingByteBuffer(i, ByteOrder.LITTLE_ENDIAN);
        result = constructIntFromByteArrayUsingByteBuffer(bytesLittleEndian, ByteOrder.LITTLE_ENDIAN);
        System.out.println(result);
    }


    /**
     * Doesn't use ByeBuffer class from java.nio package
     *
     * @param value integer to be converted to byte array
     * @param order ByteOrder
     * @return byte array
     */
    public static byte[] convertToBytes(int value, ByteOrder order)
    {
        byte[] byteArray = new byte[4];
        int shift = 0;
        for (int i = 0; i < byteArray.length;
             i++) {

            if (order == ByteOrder.BIG_ENDIAN)
                shift = (byteArray.length - 1 - i) * 8; // 24, 16, 8, 0
            else
                shift = i * 8; // 0,8,16,24

            byteArray[i] = (byte) (value >>> shift);
        }
        return byteArray;

    }

    /**
     * Doesn't use ByeBuffer class from java.nio package
     *
     * @param byteArray byte array
     * @param order     ByteOrder
     * @return integer represented by those bytes
     */
    public static int constructIntFromByteArray(byte[] byteArray, ByteOrder order)
    {
        if (byteArray.length != 4)
            return 0;
        int result = 0;
        int shift = 0;
        for (int i = 0; i < byteArray.length; i++) {
            if (order == ByteOrder.BIG_ENDIAN)
                shift = (byteArray.length - 1 - i) * 8; // 24, 16, 8, 0
            else
                shift = i * 8; // 0,8,16,24
            result = (byteArray[i] & 0x000000FF) << shift | result;
        }
        return result;
    }

    /**
     * Uses ByeBuffer class from java.nio package
     *
     * @param value integer to be converted to byte array
     * @param order ByteOrder
     * @return byte array
     */
    public static byte[] convertToBytesUsingByteBuffer(int value, ByteOrder order)
    {
        ByteBuffer buffer = ByteBuffer.allocate(4); // in java, int takes 4 bytes.
        buffer.order(order);
        return buffer.putInt(value).array();
    }

    /**
     * Uses ByeBuffer class from java.nio package
     *
     * @param byteArray byte array
     * @param order     ByteOrder
     * @return integer represented by those bytes
     */
    public static int constructIntFromByteArrayUsingByteBuffer(byte[] byteArray, ByteOrder order)
    {
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);
        buffer.order(order);
        return buffer.getInt();
    }

}
