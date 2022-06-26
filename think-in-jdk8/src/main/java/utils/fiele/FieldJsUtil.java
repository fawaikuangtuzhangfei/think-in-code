package utils.fiele;

/**
 * @author nanshoudabaojian
 * @date 2022-05-29 14:57
 */
public class FieldJsUtil {

    public static void main(String[] args) {
        generous();
    }

    public static String generous(){
        String result = new String("if (!params.%s) {\n" +
                "        list.push({\n" +
                "            fieldCode: \"%s\",\n" +
                "            fieldName: \"%s\"\n" +
                "        })\n" +
                "    }");
        String str = "ahjszqx,户籍所在地区\n" +
                "azjhm,证件号码\n" +
                "ackrsjhm,银行预留手机号码\n" +
                "akhxm,申请人姓名\n" +
                "ahjszsf,户籍所在省份\n" +
                "asqrzy,申请人职业\n" +
                "ahkrjjkzh,借记卡帐号\n" +
                "ahjszdz,户籍地详细地址\n" +
                "ahjszcs,户籍所在城市";
        String[] split = str.split("\n");
        for (String s : split) {
            String[] split1 = s.split(",");
            String param = split1[0];
            String msg = split1[1];
            System.out.println(String.format(result, param, param, msg));
        }
        System.out.println("结束...");
        return "结束";
    }
}
