/*
 * Copyright 2012-2015 Johns Hopkins University HLTCOE. All rights reserved.
 * See LICENSE in the project root directory.
 */
package edu.jhu.hlt.alnc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class that can be used to convert ALNC files to {@link ALNCArticleBean} objects. 
 * <br/>
 * <br/>
 * Each file, as of 2015/2/23, contain one JSON object per line.
 */
public class ALNCFileConverter implements AutoCloseable {

  private static final ObjectMapper om = new ObjectMapper();
  
  private final InputStream is;
  private final InputStreamReader isr;
  private final BufferedReader br;
  
  /**
   * Wrap an {@link InputStream} that represents ALNC JSON, one JSON object per line.
   *
   * @param is an {@link InputStream} over properly formed ALNC JSON data
   */
  public ALNCFileConverter(InputStream is) {
    this.is = is;
    this.isr = new InputStreamReader(is, StandardCharsets.UTF_8);
    this.br = new BufferedReader(this.isr);
  }
  
  /**
   * Return a {@link Stream} of {@link ALNCArticleBean} objects. This stream should be
   * closed when processing is complete.
   * <br/>
   * <br/>
   * Warning: while unlikely, this method can throw an unchecked exception. This will
   * most likely occur when the underlying InputStream does not represent ALNC JSON data.
   * 
   * @return a {@link Stream} of {@link ALNCArticleBean} objects.
   * @throws IOException if there is an issue reading the underlying archive.
   * @throws UncheckedIOException if there is an issue with the conversion. 
   */
  public Stream<ALNCArticleBean> stream() throws IOException {
    return this.br.lines()
        .sequential()
        .map(l -> {
          try {
            // unlikely to throw, provided stream is corrent JSON objects.
            return om.readValue(l, ALNCArticleBean.class);
          } catch (IOException e) {
            throw new UncheckedIOException(e);
          }
        });
  }


  @Override
  public void close() throws IOException {
    this.br.close();
    this.isr.close();
    this.is.close();
  }
}
