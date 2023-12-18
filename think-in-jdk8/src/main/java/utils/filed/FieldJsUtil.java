package utils.filed;

/**
 * 字段转js校验
 * @author yechaoa
 * @date 2022-05-29 14:57
 */
public class FieldJsUtil {

    public static void main(String[] args) {
        generous();
    }

    public static String generous(){
        String result = new String("if (!params.%s && params.%s != 0) {\n" +
                "        list.push({\n" +
                "            fieldCode: \"%s\",\n" +
                "            fieldName: \"%s\"\n" +
                "        })\n" +
                "    }");
        String str = "carEvaluationReportPrice,二手车评估价格 / 车辆评估价\n" +
                "appName,品牌\n" +
                "fxsj,实际成交价\n" +
                "leaseType,租赁类型\n" +
                "f050,购置税\n" +
                "f060,GPS费用\n" +
                "frze,客户融资额\n" +
                "businesstype,业务类型\n" +
                "axjzdcsName,居住地址 市-中文\n" +
                "ixjzdjznx,现居住地居住年限\n" +
                "fzdj,官方指导价\n" +
                "fsfje,首付金额\n" +
                "acxName,车型\n" +
                "arzqx,融资期限\n" +
                "fshnx,税后年薪(万元)\n";
        String[] split = str.split("\n");
        for (String s : split) {
            String[] split1 = s.split(",");
            String param = split1[0];
            String msg = split1[1];
            System.out.println(String.format(result, param, param, param, msg));
        }
        System.out.println("结束...");
        return "结束";
    }
}
