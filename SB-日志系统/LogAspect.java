@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(* cn.xiongdi.ocdm.server.controller.*.*Controller.*(..))")
    public void logPointcut(){}

    @Before("logPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("▼▼　Restful Api Name　==> " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("[ARGS] : " + Arrays.toString(joinPoint.getArgs()));
        startTime.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "ret", pointcut = "logPointcut()")
    public void doAfterReturning(Object ret) {
        log.info("[Result] : " + ret);
        log.info("▲▲　COST TIME　==> " + (System.currentTimeMillis() - startTime.get()));
    }

    @AfterThrowing(throwing="ex", pointcut="logPointcut()")
    public void doAfterThrowing(Throwable ex) {
        log.error("[EXCEPTION] : " + ex);
    }
}