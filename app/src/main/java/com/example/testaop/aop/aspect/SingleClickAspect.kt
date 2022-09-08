package com.example.testaop.aop.aspect

import android.util.Log
import android.view.View
import com.example.testaop.R
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import java.util.*


/**
 * Created by baixiaokang on 16/12/9.
 * {link https://github.com/north2016/T-MVP/blob/master/app/src/main/java/com/aop/SingleClickAspect.java}
 * 防止View被连续点击,间隔时间600ms
 */

@Aspect
class SingleClickAspect {

    @Pointcut("execution(@com.example.testaop.aop.annotation.SingleClick * *(..))") //方法切入点
    fun methodAnnotated() {

    }

    @Around("methodAnnotated()")//在连接点进行方法替换
    @Throws(Throwable::class)
    fun aroundJoinPoint(joinPoint: ProceedingJoinPoint) {


            val lastClickTime =0

                Log.d(TAG, "lastClickTime:$lastClickTime")

            val currentTime = Calendar.getInstance().timeInMillis
            if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {//过滤掉600毫秒内的连续点击


                    Log.d(TAG, "currentTime:$currentTime")

                joinPoint.proceed()//执行原方法

        }
    }

    companion object {

        val TAG = "SingleClickAspect"
        val MIN_CLICK_DELAY_TIME = 600
        internal var TIME_TAG = R.id.click_time
    }
}
