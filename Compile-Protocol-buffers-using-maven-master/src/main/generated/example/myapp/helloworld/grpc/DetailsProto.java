// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: details.proto

package example.myapp.helloworld.grpc;

public final class DetailsProto {
  private DetailsProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_details_Details_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_details_Details_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rdetails.proto\022\007details\"\223\001\n\007Details\022\r\n\005" +
      "query\030\001 \001(\t\022\014\n\004Year\030\002 \001(\t\022\r\n\005State\030\003 \001(\t" +
      "\022\014\n\004Type\030\004 \001(\t\022\016\n\006Length\030\005 \001(\t\022\017\n\007Expens" +
      "e\030\006 \001(\t\022\r\n\005Value\030\007 \001(\t\022\016\n\006Range1\030\010 \001(\t\022\016" +
      "\n\006Range2\030\t \001(\tB/\n\035example.myapp.hellowor" +
      "ld.grpcB\014DetailsProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_details_Details_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_details_Details_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_details_Details_descriptor,
        new java.lang.String[] { "Query", "Year", "State", "Type", "Length", "Expense", "Value", "Range1", "Range2", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
