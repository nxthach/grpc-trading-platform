// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common/common.proto

package com.vinsguru.common;

/**
 * Protobuf enum {@code common.Ticker}
 */
public enum Ticker
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>UNKNOWN = 0;</code>
   */
  UNKNOWN(0),
  /**
   * <code>APPLE = 1;</code>
   */
  APPLE(1),
  /**
   * <code>GOOGLE = 2;</code>
   */
  GOOGLE(2),
  /**
   * <code>AMAZON = 3;</code>
   */
  AMAZON(3),
  /**
   * <code>MICROSOFT = 4;</code>
   */
  MICROSOFT(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>UNKNOWN = 0;</code>
   */
  public static final int UNKNOWN_VALUE = 0;
  /**
   * <code>APPLE = 1;</code>
   */
  public static final int APPLE_VALUE = 1;
  /**
   * <code>GOOGLE = 2;</code>
   */
  public static final int GOOGLE_VALUE = 2;
  /**
   * <code>AMAZON = 3;</code>
   */
  public static final int AMAZON_VALUE = 3;
  /**
   * <code>MICROSOFT = 4;</code>
   */
  public static final int MICROSOFT_VALUE = 4;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Ticker valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Ticker forNumber(int value) {
    switch (value) {
      case 0: return UNKNOWN;
      case 1: return APPLE;
      case 2: return GOOGLE;
      case 3: return AMAZON;
      case 4: return MICROSOFT;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Ticker>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Ticker> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Ticker>() {
          public Ticker findValueByNumber(int number) {
            return Ticker.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.vinsguru.common.Common.getDescriptor().getEnumTypes().get(0);
  }

  private static final Ticker[] VALUES = values();

  public static Ticker valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Ticker(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:common.Ticker)
}

