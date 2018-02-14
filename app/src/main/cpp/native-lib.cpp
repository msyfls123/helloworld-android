#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_cc_ebichu_helloworld_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello world from C++ APP";
    return env->NewStringUTF(hello.c_str());
}
