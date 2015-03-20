/*
 * Copyright 2012-2015 Johns Hopkins University HLTCOE. All rights reserved.
 * See LICENSE in the project root directory.
 */
package alnc;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.Test;

import edu.jhu.hlt.alnc.ALNCArticleBean;
import edu.jhu.hlt.alnc.ALNCFileConverter;

public class ALNCFileConverterTest {
  Path p = Paths.get("src/test/resources/fake.json");
  
  @Test
  public void testALNCFileConverter() throws IOException {
    try(InputStream is = Files.newInputStream(p);
        ALNCFileConverter conv = new ALNCFileConverter(is);
        Stream<ALNCArticleBean> beanStream = conv.stream();) {
      assertEquals(2, beanStream.count());
    }
  }
}
