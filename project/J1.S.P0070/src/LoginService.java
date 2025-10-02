import java.util.Locale;

public class LoginService {
    private final Validation validation;
    private static final char[] chars = {
            '1','A','a','B','b','C','c','2','D','d','E','e','F','f','3',
            'G','g','H','h','I','i','J','j','K','k','L','l','4','M','m','N','n',
            'O','o','5','P','p','Q','q','R','r','S','s','T','t','6','7','U','u',
            'V','v','W','w','8','X','x','Y','y','Z','z','9'
    };

    public LoginService(Validation validation) {
        this.validation = validation;
    }

    public void login(Locale language) {
        validation.getWordLanguage(language, "enterAccountNumber");
        int accountNumber = validation.checkInputAccount(language);

        validation.getWordLanguage(language, "enterPassword");
        String passString = checkInputPassword(language);

        System.out.print("Captcha: ");
        String captchaGenerated = generateCaptchaText();
        while (true) {
            if (checkInputCaptcha(captchaGenerated, language)) {
                validation.getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                validation.getWordLanguage(language, "errCaptchaIncorrect");
                System.out.println();
            }
        }
    }

    private String checkInputPassword(Locale language) {
        String result;
        while (true) {
            result = validation.checkInputString(language);
            if (isValidPassword(result, language)) {
                return result;
            }
        }
    }

    private boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            validation.getWordLanguage(language, "errCheckAlphanumericPassword");
            System.out.println();
            validation.getWordLanguage(language, "enterPassword");
            return false;
        }
        int countDigit = 0;
        int countLetter = 0;
        for (int i = 0; i < lengthPassword; i++) {
            if (Character.isDigit(password.charAt(i))) {
                countDigit++;
            } else if (Character.isLetter(password.charAt(i))) {
                countLetter++;
            }
        }
        if (countDigit < 1 || countLetter < 1) {
            validation.getWordLanguage(language, "errCheckAlphanumericPassword");
            System.out.println();
            validation.getWordLanguage(language, "enterPassword");
            return false;
        }
        return true;
    }

    private boolean checkInputCaptcha(String captchaGenerated, Locale language) {
        System.out.println(captchaGenerated);
        validation.getWordLanguage(language, "enterCaptcha");
        String captchaInput = validation.checkInputString(language);
        for (int i = 0; i < captchaInput.length(); i++) {
            if (!captchaGenerated.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private String generateCaptchaText() {
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LENGTH; i++) {
            int index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }
}
