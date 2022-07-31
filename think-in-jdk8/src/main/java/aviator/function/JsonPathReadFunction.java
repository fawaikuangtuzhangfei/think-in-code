package aviator.function;

import com.alibaba.fastjson.JSONPath;
import com.googlecode.aviator.*;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nanshoudabaojian
 * @date 2022-07-31 13:04
 */
public class JsonPathReadFunction extends AbstractFunction {

    public static void main(String[] args) {
        String url = "{\"code\": \"0000\", \t\"message\": \"挡板\", \t\"outSts\": \"0600\", \t\"expanding\": { \t\t\"creditAmt\": \"10000\", \t\t\"outAdvice\": \"挡板\", \t\t\"signUrl\": \"www.baidu.com\"  \t} }";
        String path = "jsonPathRead(#url, '$.expanding.signUrl')";

        AviatorEvaluatorInstance engine = AviatorEvaluator.newInstance(EvalMode.INTERPRETER);
        engine.setOption(Options.TRACE_EVAL, true);
        engine.addFunction(new JsonPathReadFunction());
        Expression exp = engine.compile(path);
        Map<String, Object> env = new HashMap<>();
        env.put("url", url);
        Object urlObj = exp.execute(env);
        System.out.println(String.valueOf(urlObj));
    }

    @Override
    public AviatorObject call(Map<String, Object> env,
                              AviatorObject jsonObject, AviatorObject pathObject) {
        String json = FunctionUtils.getStringValue(jsonObject, env);
        String path = FunctionUtils.getStringValue(pathObject, env);
        Object read = JSONPath.read(json, path);
        return new AviatorString((String) read);
    }

    @Override
    public String getName() {
        return "jsonPathRead";
    }
}
