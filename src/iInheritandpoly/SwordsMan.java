package iInheritandpoly;

import static java.lang.System.out;

/**
 * @program: JavaTest
 * @description: ${c#中如果标记override 需要父类是virtual abstract}
 * @author: Mr.ZeroCamel
 * @create: 2020-04-25 23:28
 **/
public class SwordsMan extends BaseRole {

    /**
    * @Description: ${重新定义方式时 权限可以放大不可以缩小 签名一致}$
    * @Param: []
    * @return: void
    * @Author: Mr.ZeroCamel
    * @Date: 2020/5/1
    */
    @Override
    public void fight()
    {
        out.println("挥剑攻击");
    }
}
