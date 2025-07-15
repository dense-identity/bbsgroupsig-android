package io.github.denseidentity.bbsgroupsig

object BBSGS {
    data class SetupResult(val gpk: ByteArray, val osk: ByteArray, val isk: ByteArray)

    init {
        System.loadLibrary("bbsgs_jni")
    }

    @JvmStatic external fun bbs04InitPairing()
    @JvmStatic external fun bbs04Setup(): SetupResult
    @JvmStatic external fun bbs04UserKeygen(gpk: ByteArray, isk: ByteArray): ByteArray
    @JvmStatic external fun bbs04Sign(gpk: ByteArray, usk: ByteArray, msg: ByteArray): ByteArray
    @JvmStatic external fun bbs04VerifyUsk(gpk: ByteArray, usk: ByteArray): Boolean
    @JvmStatic external fun bbs04Verify(gpk: ByteArray, sig: ByteArray, msg: ByteArray): Boolean
    @JvmStatic external fun bbs04Open(gpk: ByteArray, osk: ByteArray, sig: ByteArray): ByteArray
    @JvmStatic external fun ecScalarRandom(): ByteArray
    @JvmStatic external fun ecScalarInverse(scalar: ByteArray): ByteArray
    @JvmStatic external fun ecG1HashToPoint(msg: ByteArray): ByteArray
    @JvmStatic external fun ecG1Mul(point: ByteArray, scalar: ByteArray): ByteArray
}