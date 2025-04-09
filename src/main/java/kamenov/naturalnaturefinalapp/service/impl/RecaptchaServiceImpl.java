//package kamenov.naturalnaturefinalapp.service.impl;
//
//
//import kamenov.naturalnaturefinalapp.service.RecaptchaService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class RecaptchaServiceImpl implements RecaptchaService {
//
//    @Value("${secret_key}")
//    private String recaptchaSecret;
//    private static final Logger logger = LoggerFactory.getLogger(RecaptchaService.class);
//    private static final String RECAPTCHA_VERIFY_URL =
//            "https://www.google.com/recaptcha/api/siteverify";
//    public boolean validateRecaptcha(String recaptchaResponse) {
//        if (recaptchaResponse == null || recaptchaResponse.isEmpty()) {
//            logger.warn("reCAPTCHA response is null or empty");
//            return false;
//        }
//
//        RestTemplate restTemplate = new RestTemplate();
//        String url = RECAPTCHA_VERIFY_URL + "?secret=" + recaptchaSecret + "&response=" + recaptchaResponse;
//        logger.info("Verifying reCAPTCHA with URL: {}", url.replace(recaptchaSecret, "[REDACTED]")); // Не показваме secret key в лога
//
//        try {
//            RecaptchaResponse response = restTemplate.getForObject(url, RecaptchaResponse.class);
//            if (response == null) {
//                logger.error("reCAPTCHA response is null");
//                return false;
//            }
//            logger.info("reCAPTCHA response: success={}, error-codes={}", response.isSuccess(), response.getErrorCodes());
//            if (!response.isSuccess()) {
//                logger.warn("reCAPTCHA validation failed. Error codes: {}", response.getErrorCodes());
//            }
//            return response.isSuccess();
//        } catch (Exception e) {
//            logger.error("Error validating reCAPTCHA: {}", e.getMessage(), e);
//            return false;
//        }
//    }
//}
//
//class RecaptchaResponse {
//    private boolean success;
//    private String[] errorCodes;
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String[] getErrorCodes() {
//        return errorCodes;
//    }
//
//    public void setErrorCodes(String[] errorCodes) {
//        this.errorCodes = errorCodes;
//    }
////    @Override
////    public boolean validateRecaptcha(String recaptchaResponse) {
////        RestTemplate restTemplate = new RestTemplate();
////        Map<String, String> params = new HashMap<>();
////        params.put("secret", recaptchaSecret);
////        params.put("response", recaptchaResponse);
////        // Използваме POST заявка към API-то на Google
////        RecaptchaResponse apiResponse = restTemplate.postForObject(
////                RECAPTCHA_VERIFY_URL + "?secret={secret}&response={response}",
////                null,
////                RecaptchaResponse.class,
////                params
////        );
////        return apiResponse != null && apiResponse.success;
////    }
//
////
////        private static final String RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";
////        private static final String SECRET_KEY = "${secret_key_recaptcha}"; // Заменете с вашия Secret Key
////
////        private final WebClient webClient;
////
////        public RecaptchaServiceImpl(WebClient.Builder webClientBuilder) {
////            this.webClient = webClientBuilder.baseUrl(RECAPTCHA_VERIFY_URL).build();
////        }
////@Override
////        public boolean validateRecaptcha(String recaptchaToken) {
////            Mono<RecaptchaResponse> responseMono = webClient.post()
////                    .uri(uriBuilder -> uriBuilder
////                            .queryParam("secret", SECRET_KEY)
////                            .queryParam("response", recaptchaToken)
////                            .build())
////                    .retrieve()
////                    .bodyToMono(RecaptchaResponse.class);
////
////            RecaptchaResponse response = responseMono.block();
////            return response != null && response.isSuccess();
////        }
//
////        private static class RecaptchaResponse {
////            private boolean success;
////            private String challenge_ts;
////            private String hostname;
////
////            public boolean isSuccess() {
////                return success;
////            }
////
////            public void setSuccess(boolean success) {
////                this.success = success;
////            }
////
////            // Getters and Setters
////        }
//    }
//
