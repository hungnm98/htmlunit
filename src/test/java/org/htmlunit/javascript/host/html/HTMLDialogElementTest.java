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
package org.htmlunit.javascript.host.html;

import org.htmlunit.WebDriverTestCase;
import org.htmlunit.junit.BrowserRunner;
import org.htmlunit.junit.BrowserRunner.Alerts;
import org.htmlunit.junit.BrowserRunner.HtmlUnitNYI;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Unit tests for {@link HTMLDialogElement}.
 *
 * @author Ronald Brill
 */
@RunWith(BrowserRunner.class)
public class HTMLDialogElementTest extends WebDriverTestCase {

    private static final String DUMP_EVENT_FUNCTION = "  function dump(event) {\n"
            + "    log(event);\n"
            + "    log(event.type);\n"
            + "    log(event.bubbles);\n"
            + "    log(event.cancelable);\n"
            + "    log(event.composed);\n"
            + "    log(event.target);\n"
            + "  }\n";

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "null", "true", "", "false", "null", "true", "",
                       "true", "", "true", "TrUE", "false", "null"},
            IE = "No")
    public void open() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.open = true;\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.open = false;\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.open = 'true';\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.open = 'faLSE';\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.setAttribute('open', 'TrUE');\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.removeAttribute('open');\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "null", "false", "null", "true", "", "true", "blah", "false", "null"},
            IE = "No")
    public void openString() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.open = '';\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.open = 'abc';\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.setAttribute('open', 'blah');\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.removeAttribute('open');\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "null", "true", "", "true", ""},
            IE = "No")
    public void show() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"true", "", "true", ""},
            IE = "No")
    public void showAlreadyOpend() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester' open>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "null", "true", "", "InvalidStateError"},
            IE = "No")
    public void showModal() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.showModal();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        try {\n"
            + "          dia.showModal();\n"
            + "          log(dia.open);\n"
            + "          log(dia.getAttribute('open'));\n"
            + "        } catch(e) { log('InvalidStateError'); }"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"true", "", "InvalidStateError"},
            IE = "No")
    public void showModalAlreadyOpend() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        try {\n"
            + "          dia.showModal();\n"
            + "          log(dia.open);\n"
            + "          log(dia.getAttribute('open'));\n"
            + "        } catch(e) { log('InvalidStateError'); }"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester' open>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "null", "true", "", "true", ""},
            IE = "No")
    public void showAfterShowModal() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        dia.showModal();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"

            + "        try {\n"
            + "          dia.show();\n"
            + "          log(dia.open);\n"
            + "          log(dia.getAttribute('open'));\n"
            + "        } catch(e) { log('InvalidStateError'); }"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "null", "", "true", "", "",
                       "false", "null", "", "false", "null", "",
                       "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]"},
            IE = "No")
    public void close() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.close();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.close();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "null", "", "true", "", "",
                       "false", "null", "", "false", "null", "", "closed"},
            IE = "No")
    public void closeOnclose() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.close();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.close();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester' onclose='log(\"closed\")'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "null", "", "true", "", "",
                       "false", "null", "Html", "false", "null", "Html",
                       "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]"},
            IE = "No")
    public void closeReturnValue() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.close('Html');\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"

            + "        dia.close('unit');\n"
            + "        log(dia.open);\n"
            + "        log(dia.getAttribute('open'));\n"
            + "        log(dia.returnValue);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "", "1", "true", "1", "2", "false", "3", "4",
                       "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]"},
            IE = "No")
    public void returnValue() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(dia.returnValue);\n"

            + "        dia.returnValue = '1';\n"
            + "        log(dia.returnValue);\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"
            + "        log(dia.returnValue);\n"

            + "        dia.returnValue = '2';\n"
            + "        log(dia.returnValue);\n"

            + "        dia.close('3');\n"
            + "        log(dia.open);\n"
            + "        log(dia.returnValue);\n"

            + "        dia.returnValue = '4';\n"
            + "        log(dia.returnValue);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "string ", "string null", "string undefined", "string 4", "string [object Object]"},
            IE = "No")
    public void returnValueSpecial() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"
            + "        log(typeof dia.returnValue + ' ' + dia.returnValue);\n"

            + "        dia.returnValue = null;\n"
            + "        log(typeof dia.returnValue + ' ' + dia.returnValue);\n"

            + "        dia.returnValue = undefined;\n"
            + "        log(typeof dia.returnValue + ' ' + dia.returnValue);\n"

            + "        dia.returnValue = 4;\n"
            + "        log(typeof dia.returnValue + ' ' + dia.returnValue);\n"

            + "        dia.returnValue = { a: '#' };\n"
            + "        log(typeof dia.returnValue + ' ' + dia.returnValue);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "true", "false",
                       "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]"},
            IE = "No")
    @HtmlUnitNYI(CHROME = {"false", "true",
                           "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]",
                           "false"},
            EDGE = {"false", "true",
                    "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]",
                    "false"},
            FF = {"false", "true",
                  "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]",
                  "false"},
            FF_ESR = {"false", "true",
                      "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]",
                      "false"})
    public void formClosesDialog() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"

            + "        document.getElementById('close').click();\n"
            + "        log(dia.open);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "      <form method='dialog'>\n"
            + "        <button id='close'>OK</button>\n"
            + "      </form>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "true", "false",
                       "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]"},
            IE = "No")
    @HtmlUnitNYI(CHROME = {"false", "true",
                           "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]",
                           "false"},
            EDGE = {"false", "true",
                    "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]",
                    "false"},
            FF = {"false", "true",
                  "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]",
                  "false"},
            FF_ESR = {"false", "true",
                      "[object Event]", "close", "false", "false", "false", "[object HTMLDialogElement]",
                      "false"})
    public void formClosesDialogWithoutJs() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"

            + "        document.getElementById('close').click();\n"
            + "        log(dia.open);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "      <form method='dialog'>\n"
            + "        <button id='close'>OK</button>\n"
            + "      </form>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "true", "true"},
            IE = "No")
    public void formGet() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_WINDOW_NAME_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"

            + "        document.getElementById('close').click();\n"
            + "        log(dia.open);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "      <form method='get' action='" + URL_SECOND + "'>\n"
            + "        <button id='close'>OK</button>\n"
            + "      </form>\n"
            + "    </dialog>\n"
            + "  </body>\n"
            + "</html>";

        final String secondContent
            = "<html><head><title>second</title></head><body>\n"
            + "<p>hello world</p>\n"
            + "</body></html>";
        getMockWebConnection().setDefaultResponse(secondContent);

        loadPage2(html);
        Thread.sleep(DEFAULT_WAIT_TIME / 20); // FF
        verifyWindowName2(getWebDriver(), getExpectedAlerts());
    }

    /**
     * @throws Exception if an error occurs
     */
    @Test
    @Alerts(DEFAULT = {"false", "true", "true"},
            IE = "No")
    public void formOutsideDialog() throws Exception {
        final String html =
            "<html>\n"
            + "  <head>\n"
            + "    <script>\n"
            + LOG_TITLE_FUNCTION
            + DUMP_EVENT_FUNCTION
            + "      function test() {\n"
            + "        var dia = document.getElementById('tester');\n"
            + "        if (typeof HTMLDialogElement !== 'function') { log('No'); return; }\n"

            + "        dia.addEventListener('close', (event) => {\n"
            + "          dump(event);\n"
            + "        });\n"

            + "        log(dia.open);\n"

            + "        dia.show();\n"
            + "        log(dia.open);\n"

            + "        document.getElementById('close').click();\n"
            + "        log(dia.open);\n"
            + "      }\n"
            + "    </script>\n"
            + "  </head>\n"
            + "  <body onload='test()'>\n"
            + "    <dialog id='tester'>\n"
            + "      <p>HtmlUNit dialog</p>\n"
            + "    </dialog>\n"

            + "    <form method='dialog'>\n"
            + "      <button id='close'>OK</button>\n"
            + "    </form>\n"

            + "  </body>\n"
            + "</html>";

        loadPageVerifyTitle2(html);
    }
}
