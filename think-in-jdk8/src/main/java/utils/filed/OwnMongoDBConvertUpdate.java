package utils.filed;

/**
 * 将订单号和dataSeq转换为mongoDB update语句
 * @author yechaoa
 * @date 2023-03-06 14:35
 */
public class OwnMongoDBConvertUpdate {
    public static void main(String[] args) {
        String str = getStr();
        String updateSql = "db.dscSyncDTO.updateOne({\"applyNo\":\"%s\",\"dataSeq\":\"%s\"}, {$set:{\"salesApplyMainExtraDTO\":{\"subjectFeeInfoList\":[{\"subjectCode\":\"TJHT\",\"rentingCompanyCode\":\"1111\",\"subjectName\":\"有限公司\",\"rebateRate\":\"0\",\"rebateSubjectType\":2},{\"subjectCode\":\"sss\",\"rentingCompanyCode\":\"123\",\"subjectName\":\"公司\",\"rebateRate\":\"0\",\"rebateSubjectType\":9}]}}})\n";

        String[] split = str.split("\n");
        for (String s : split) {
            String[] split1 = s.split(",");
            String applyNo = split1[0];
            String dataSeq = split1[1];
            System.out.println(String.format(updateSql, applyNo, dataSeq));
        }
    }

    private static String getStr() {
        String str = "1029832755,48d11c8ebefd431a9e08bd8d69808f17\n" +
                "1039836762,786ff190efea4ab4bed5e8e581d904f0";


        return str;
    }
}
