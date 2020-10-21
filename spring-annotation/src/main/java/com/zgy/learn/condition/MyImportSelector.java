package com.zgy.learn.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: renjiaxin
 * @Despcription: 使用ImportSelector接口的实现类，定义需要导入的组件的类名的数组
 * @Date: Created in 2019/12/28 19:18
 * @Modified by:
 */
// 自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {
    // 返回值，就是到导入到容器中的组件全类名
    // AnnotationMetadata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 不能返回null, 将Blue和Yellow组件也加入其中，需要使用全类名
        return new String[]{"com.zgy.learn.bean.Blue", "com.zgy.learn.bean.Yellow"};
    }
}
