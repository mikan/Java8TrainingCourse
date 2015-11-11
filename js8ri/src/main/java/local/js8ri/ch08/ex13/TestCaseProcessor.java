/*
 * Copyright (c) 2015. Yutaka Kato. All rights reserved.
 * https://github.com/mikan/Java8TrainingCourse
 */

package local.js8ri.ch08.ex13;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Use run.sh for run this program.
 *
 * @author mikan
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"*"})
public class TestCaseProcessor extends AbstractProcessor {

    @SuppressWarnings("unchecked")
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {
        for (TypeElement annotation : annotations) {
            System.out.println("Found annotation: " + annotation.getQualifiedName());
            for (Element element : roundEnvironment.getElementsAnnotatedWith(annotation)) {
                TestCase testCase = element.getAnnotation(TestCase.class);
                if (testCase != null) {
                    try {
                        Class clazz = Class.forName(((TypeElement) element.getEnclosingElement()).getQualifiedName().toString());
                        Method mainMethod = clazz.getMethod("main", String[].class);
                        if (mainMethod != null) {
                            String[] args = new String[]{"arg1", "arg2"};
                            mainMethod.invoke(null, (Object) args);
                        } else {
                            System.err.println("main method not found!");
                        }
                    } catch (ReflectiveOperationException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return true;
    }
}