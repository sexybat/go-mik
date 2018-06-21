#include <jni.h>
#include <string>
//
//JNIEXPORT jstring JNICALL
//Java_id_co_next_1innovation_go_1mik_data_network_Api_invokeBaseUrl(JNIEnv *env, jobject instance) {
//    return env->NewStringUTF("aHR0cDovL2dvLW1pay5hcGkubmV4dC1pbm5vdmF0aW9uLmNvLmlkL2FwaS8=");
//}
extern "C" {
JNIEXPORT jstring JNICALL
Java_id_co_next_1innovation_go_1mik_data_network_Api_invokeBaseUrl(JNIEnv *env,
                                                                              jobject instance) {
    return env->NewStringUTF("aHR0cDovL2dvLW1pay5hcGkubmV4dC1pbm5vdmF0aW9uLmNvLmlkL2FwaS8=");
}
}