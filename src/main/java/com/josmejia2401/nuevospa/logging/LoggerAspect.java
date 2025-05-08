package com.josmejia2401.nuevospa.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log4j2
public class LoggerAspect {

    @Around("@annotation(com.josmejia2401.nuevospa.logging.Logger)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String method = signature.getDeclaringTypeName() + "." + signature.getName();
        Object[] args = joinPoint.getArgs();

        log.info("📥 Entrando a: {} con parámetros: {}", method, Arrays.toString(args));

        try {
            Object result = joinPoint.proceed();
            log.info("📤 Salida de {}: {}", method, result);
            return result;
        } catch (Exception ex) {
            log.error("💥 Excepción en {} con parámetros {}: {}", method, Arrays.toString(args), ex.getMessage(), ex);
            throw ex;
        }
    }
}

