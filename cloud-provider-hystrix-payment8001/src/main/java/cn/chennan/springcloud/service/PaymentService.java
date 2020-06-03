package cn.chennan.springcloud.service;

/**
 * @author cn
 * @date 2020-06-02 14:31
 */
public interface PaymentService {

    /**
     * 正常访问, 肯定OK
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id);

    public String paymentInfo_TimeOut(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
