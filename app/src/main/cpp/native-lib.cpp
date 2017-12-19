#include <jni.h>
#include "Module1Math.h"
#include "Module2Math.h"

extern "C"
JNIEXPORT jint JNICALL
Java_com_vishal83_test_cmake_testnativecmake_MainActivity_sumFromJNI (JNIEnv *env, jobject instance, jint a, jint b)
{

  return Module2Math::SUM (a, b);

}

extern "C"
JNIEXPORT jint JNICALL
Java_com_vishal83_test_cmake_testnativecmake_MainActivity_productFromJNI (JNIEnv *env, jobject instance, jint a, jint b)
{

  return Module1Math::MULTIPLY (a, b);

}