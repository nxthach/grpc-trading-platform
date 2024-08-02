// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stock-service.proto

package com.vinsguru.stock;

/**
 * Protobuf type {@code stock.PriceUpdate}
 */
public final class PriceUpdate extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:stock.PriceUpdate)
    PriceUpdateOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PriceUpdate.newBuilder() to construct.
  private PriceUpdate(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PriceUpdate() {
    ticker_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PriceUpdate();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.vinsguru.stock.StockServiceOuterClass.internal_static_stock_PriceUpdate_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.vinsguru.stock.StockServiceOuterClass.internal_static_stock_PriceUpdate_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.vinsguru.stock.PriceUpdate.class, com.vinsguru.stock.PriceUpdate.Builder.class);
  }

  public static final int TICKER_FIELD_NUMBER = 1;
  private int ticker_ = 0;
  /**
   * <code>.common.Ticker ticker = 1;</code>
   * @return The enum numeric value on the wire for ticker.
   */
  @java.lang.Override public int getTickerValue() {
    return ticker_;
  }
  /**
   * <code>.common.Ticker ticker = 1;</code>
   * @return The ticker.
   */
  @java.lang.Override public com.vinsguru.common.Ticker getTicker() {
    com.vinsguru.common.Ticker result = com.vinsguru.common.Ticker.forNumber(ticker_);
    return result == null ? com.vinsguru.common.Ticker.UNRECOGNIZED : result;
  }

  public static final int PRICE_FIELD_NUMBER = 2;
  private int price_ = 0;
  /**
   * <code>int32 price = 2;</code>
   * @return The price.
   */
  @java.lang.Override
  public int getPrice() {
    return price_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (ticker_ != com.vinsguru.common.Ticker.UNKNOWN.getNumber()) {
      output.writeEnum(1, ticker_);
    }
    if (price_ != 0) {
      output.writeInt32(2, price_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (ticker_ != com.vinsguru.common.Ticker.UNKNOWN.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, ticker_);
    }
    if (price_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, price_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.vinsguru.stock.PriceUpdate)) {
      return super.equals(obj);
    }
    com.vinsguru.stock.PriceUpdate other = (com.vinsguru.stock.PriceUpdate) obj;

    if (ticker_ != other.ticker_) return false;
    if (getPrice()
        != other.getPrice()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TICKER_FIELD_NUMBER;
    hash = (53 * hash) + ticker_;
    hash = (37 * hash) + PRICE_FIELD_NUMBER;
    hash = (53 * hash) + getPrice();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.vinsguru.stock.PriceUpdate parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.vinsguru.stock.PriceUpdate parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.vinsguru.stock.PriceUpdate parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.vinsguru.stock.PriceUpdate parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.vinsguru.stock.PriceUpdate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code stock.PriceUpdate}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:stock.PriceUpdate)
      com.vinsguru.stock.PriceUpdateOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.vinsguru.stock.StockServiceOuterClass.internal_static_stock_PriceUpdate_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.vinsguru.stock.StockServiceOuterClass.internal_static_stock_PriceUpdate_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.vinsguru.stock.PriceUpdate.class, com.vinsguru.stock.PriceUpdate.Builder.class);
    }

    // Construct using com.vinsguru.stock.PriceUpdate.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      ticker_ = 0;
      price_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.vinsguru.stock.StockServiceOuterClass.internal_static_stock_PriceUpdate_descriptor;
    }

    @java.lang.Override
    public com.vinsguru.stock.PriceUpdate getDefaultInstanceForType() {
      return com.vinsguru.stock.PriceUpdate.getDefaultInstance();
    }

    @java.lang.Override
    public com.vinsguru.stock.PriceUpdate build() {
      com.vinsguru.stock.PriceUpdate result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.vinsguru.stock.PriceUpdate buildPartial() {
      com.vinsguru.stock.PriceUpdate result = new com.vinsguru.stock.PriceUpdate(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.vinsguru.stock.PriceUpdate result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.ticker_ = ticker_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.price_ = price_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.vinsguru.stock.PriceUpdate) {
        return mergeFrom((com.vinsguru.stock.PriceUpdate)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.vinsguru.stock.PriceUpdate other) {
      if (other == com.vinsguru.stock.PriceUpdate.getDefaultInstance()) return this;
      if (other.ticker_ != 0) {
        setTickerValue(other.getTickerValue());
      }
      if (other.getPrice() != 0) {
        setPrice(other.getPrice());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              ticker_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              price_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int ticker_ = 0;
    /**
     * <code>.common.Ticker ticker = 1;</code>
     * @return The enum numeric value on the wire for ticker.
     */
    @java.lang.Override public int getTickerValue() {
      return ticker_;
    }
    /**
     * <code>.common.Ticker ticker = 1;</code>
     * @param value The enum numeric value on the wire for ticker to set.
     * @return This builder for chaining.
     */
    public Builder setTickerValue(int value) {
      ticker_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.common.Ticker ticker = 1;</code>
     * @return The ticker.
     */
    @java.lang.Override
    public com.vinsguru.common.Ticker getTicker() {
      com.vinsguru.common.Ticker result = com.vinsguru.common.Ticker.forNumber(ticker_);
      return result == null ? com.vinsguru.common.Ticker.UNRECOGNIZED : result;
    }
    /**
     * <code>.common.Ticker ticker = 1;</code>
     * @param value The ticker to set.
     * @return This builder for chaining.
     */
    public Builder setTicker(com.vinsguru.common.Ticker value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      ticker_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.common.Ticker ticker = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTicker() {
      bitField0_ = (bitField0_ & ~0x00000001);
      ticker_ = 0;
      onChanged();
      return this;
    }

    private int price_ ;
    /**
     * <code>int32 price = 2;</code>
     * @return The price.
     */
    @java.lang.Override
    public int getPrice() {
      return price_;
    }
    /**
     * <code>int32 price = 2;</code>
     * @param value The price to set.
     * @return This builder for chaining.
     */
    public Builder setPrice(int value) {

      price_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 price = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrice() {
      bitField0_ = (bitField0_ & ~0x00000002);
      price_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:stock.PriceUpdate)
  }

  // @@protoc_insertion_point(class_scope:stock.PriceUpdate)
  private static final com.vinsguru.stock.PriceUpdate DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.vinsguru.stock.PriceUpdate();
  }

  public static com.vinsguru.stock.PriceUpdate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PriceUpdate>
      PARSER = new com.google.protobuf.AbstractParser<PriceUpdate>() {
    @java.lang.Override
    public PriceUpdate parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<PriceUpdate> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PriceUpdate> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.vinsguru.stock.PriceUpdate getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

