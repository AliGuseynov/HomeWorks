package az.code.springhomework.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TestAspect {

    @Before("execution(* az.code.springhomework.service.*.test())")
    public void testMethod(){
        log.info("Aspects is works");
    }
}
