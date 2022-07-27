package utils.tree;


import com.alibaba.fastjson.JSONObject;
import utils.tree.entity.Menu;
import utils.tree.entity.Tree;
import utils.tree.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yechaoa
 * @date 2022-07-27 7:42
 */
public class Test {

    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();

        String str = "20c942930be311ed80ac005056bff24d,d8948bc80bc711ed80ac005056bff24d,信审文件上传\n";

        String[] split = str.split("\n");
        for (String s : split) {
            String[] split1 = s.split(",");
            String id = split1[0];
            String parentId = split1[1];
            String name = split1[2];
            menuList.add(new Menu(id, parentId, name));
        }

        //树结构
        List<Tree<Menu>> trees = new TreeUtils<>(menuList).buildForest();
        System.out.println(JSONObject.toJSONString(trees));
    }
}
