/*
 * Copyright (c) 2002-2023 Gargoyle Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.htmlunit.html;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.htmlunit.SimpleWebTestCase;
import org.htmlunit.junit.BrowserRunner;

/**
 * Tests for {@link DomNamespaceNode}.
 *
 * @author Ahmed Ashour
 */
@RunWith(BrowserRunner.class)
public class DomNamespaceNodeTest extends SimpleWebTestCase {

    /**
     * @throws Exception if the test fails
     */
    @Test
    public void getLocalName() throws Exception {
        final String content = "<HTML></HTML>";
        final HtmlPage page = loadPage(content);
        assertEquals(1, page.getByXPath("//html").size());
    }

}
