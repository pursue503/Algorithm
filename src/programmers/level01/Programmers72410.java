package level01;


/**
 *
 * 신규 아이디 추천
 *
 * 변수명을 잘못써서 무한루프로 시간을 너무 날렸다..
 *
 */

public class Programmers72410 {

    public String solution(String new_id) {
        //1단계
        String str = new_id.toLowerCase();

        StringBuffer stringBuffer = new StringBuffer(str);

        //2 단계
        for(int i=0; i<stringBuffer.length(); i++) {
            char c = stringBuffer.charAt(i);

            if(c >= 97 && c<= 122) {
                continue; // 소문자임
            } else if( c >= 48 && c<=57 ) {
                continue; // 숫자
            } else if( c == 45 || c == 46 || c == 95) { // 순새대로 - . _ 임
                continue;
            } else {
                stringBuffer.deleteCharAt(i);
                i--; // 다시 돌게해줌 지웠으니까
            }


        }


        //3 단계
        if(stringBuffer.length() > 0) {
            for(int i=0; i< stringBuffer.length(); i++) {
                if(i == stringBuffer.length() -1) break;
                if(String.valueOf(stringBuffer.charAt(i)).equals(".") && String.valueOf(stringBuffer.charAt(i +1)).equals(".")) {
                    stringBuffer.deleteCharAt(i + 1);
                    i--;
                }
            }
        }


        //4단계
        if(!stringBuffer.toString().equals("")) {
            while (String.valueOf(stringBuffer.charAt(0)).equals(".") || String.valueOf(stringBuffer.charAt(stringBuffer.length() -1)).equals(".")) {
                if(stringBuffer.toString().equals("")) break;

                if (stringBuffer.indexOf(".") == 0) {
                    stringBuffer.deleteCharAt(0);
                }
                if(stringBuffer.toString().equals("")) break;
                if (stringBuffer.lastIndexOf(".") == stringBuffer.length() -1) {
                    stringBuffer.deleteCharAt(stringBuffer.length() -1);
                }
            }
        }


        //5단계
        if(stringBuffer.toString().equals("")) {
            stringBuffer.append("a");
        }

        //6단계
        if(stringBuffer.length() >= 15) {
            stringBuffer.delete(15,stringBuffer.toString().length());
            while (String.valueOf(stringBuffer.charAt(stringBuffer.length() -1)).equals(".")) {
                if(stringBuffer.lastIndexOf(".") == stringBuffer.length() -1) {
                    stringBuffer.deleteCharAt(stringBuffer.length() -1);
                }
            }
        }

        //7단계
        if(stringBuffer.length() <= 2) {
            while (stringBuffer.length() <=2) {
                stringBuffer.append(stringBuffer.charAt(stringBuffer.length() -1));
            }
        }

        return stringBuffer.toString();
    }

}
