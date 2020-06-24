/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package at.mroland.android.imagedecoder;
/**
 * Image decoder service interface.
 */
public interface IImageDecoderService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements at.mroland.android.imagedecoder.IImageDecoderService
{
private static final java.lang.String DESCRIPTOR = "at.mroland.android.imagedecoder.IImageDecoderService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an at.mroland.android.imagedecoder.IImageDecoderService interface,
 * generating a proxy if needed.
 */
public static at.mroland.android.imagedecoder.IImageDecoderService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof at.mroland.android.imagedecoder.IImageDecoderService))) {
return ((at.mroland.android.imagedecoder.IImageDecoderService)iin);
}
return new at.mroland.android.imagedecoder.IImageDecoderService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_decodeImage:
{
data.enforceInterface(descriptor);
byte[] _arg0;
_arg0 = data.createByteArray();
at.mroland.android.imagedecoder.BitmapImage _result = this.decodeImage(_arg0);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements at.mroland.android.imagedecoder.IImageDecoderService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public at.mroland.android.imagedecoder.BitmapImage decodeImage(byte[] rawImageData) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
at.mroland.android.imagedecoder.BitmapImage _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeByteArray(rawImageData);
mRemote.transact(Stub.TRANSACTION_decodeImage, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = at.mroland.android.imagedecoder.BitmapImage.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_decodeImage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public at.mroland.android.imagedecoder.BitmapImage decodeImage(byte[] rawImageData) throws android.os.RemoteException;
}
