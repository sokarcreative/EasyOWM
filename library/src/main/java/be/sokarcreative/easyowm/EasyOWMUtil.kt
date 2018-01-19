package be.sokarcreative.easyowm

/**
 * Copyright (C) 2017 sokarcreative
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
object QuickWeatherUtil {

    fun getWeatherIcon(weatherId: String, weatherIcon: String): String = when ((if (weatherIcon.endsWith("d")) "day" else "night") + weatherId) {
        "day200" -> "\uf010"
        "day201" -> "\uf010"
        "day202" -> "\uf010"
        "day210" -> "\uf005"
        "day211" -> "\uf005"
        "day212" -> "\uf005"
        "day221" -> "\uf005"
        "day230" -> "\uf010"
        "day231" -> "\uf010"
        "day232" -> "\uf010"
        "day300" -> "\uf00b"
        "day301" -> "\uf00b"
        "day302" -> "\uf008"
        "day310" -> "\uf008"
        "day311" -> "\uf008"
        "day312" -> "\uf008"
        "day313" -> "\uf008"
        "day314" -> "\uf008"
        "day321" -> "\uf00b"
        "day500" -> "\uf00b"
        "day501" -> "\uf008"
        "day502" -> "\uf008"
        "day503" -> "\uf008"
        "day504" -> "\uf008"
        "day511" -> "\uf006"
        "day520" -> "\uf009"
        "day521" -> "\uf009"
        "day522" -> "\uf009"
        "day531" -> "\uf00e"
        "day600" -> "\uf00a"
        "day601" -> "\uf0b2"
        "day602" -> "\uf00a"
        "day611" -> "\uf006"
        "day612" -> "\uf006"
        "day615" -> "\uf006"
        "day616" -> "\uf006"
        "day620" -> "\uf006"
        "day621" -> "\uf00a"
        "day622" -> "\uf00a"
        "day701" -> "\uf009"
        "day711" -> "\uf062"
        "day721" -> "\uf0b6"
        "day731" -> "\uf063"
        "day741" -> "\uf003"
        "day761" -> "\uf063"
        "day762" -> "\uf063"
        "day781" -> "\uf056"
        "day800" -> "\uf00d"
        "day801" -> "\uf000"
        "day802" -> "\uf000"
        "day803" -> "\uf000"
        "day804" -> "\uf00c"
        "day900" -> "\uf056"
        "day902" -> "\uf073"
        "day903" -> "\uf076"
        "day904" -> "\uf072"
        "day906" -> "\uf004"
        "day957" -> "\uf050"
        "night200" -> "\uf02d"
        "night201" -> "\uf02d"
        "night202" -> "\uf02d"
        "night210" -> "\uf025"
        "night211" -> "\uf025"
        "night212" -> "\uf025"
        "night221" -> "\uf025"
        "night230" -> "\uf02d"
        "night231" -> "\uf02d"
        "night232" -> "\uf02d"
        "night300" -> "\uf02b"
        "night301" -> "\uf02b"
        "night302" -> "\uf028"
        "night310" -> "\uf028"
        "night311" -> "\uf028"
        "night312" -> "\uf028"
        "night313" -> "\uf028"
        "night314" -> "\uf028"
        "night321" -> "\uf02b"
        "night500" -> "\uf02b"
        "night501" -> "\uf028"
        "night502" -> "\uf028"
        "night503" -> "\uf028"
        "night504" -> "\uf028"
        "night511" -> "\uf026"
        "night520" -> "\uf029"
        "night521" -> "\uf029"
        "night522" -> "\uf029"
        "night531" -> "\uf02c"
        "night600" -> "\uf02a"
        "night601" -> "\uf0b4"
        "night602" -> "\uf02a"
        "night611" -> "\uf026"
        "night612" -> "\uf026"
        "night615" -> "\uf026"
        "night616" -> "\uf026"
        "night620" -> "\uf026"
        "night621" -> "\uf02a"
        "night622" -> "\uf02a"
        "night701" -> "\uf029"
        "night711" -> "\uf062"
        "night721" -> "\uf0b6"
        "night731" -> "\uf063"
        "night741" -> "\uf04a"
        "night761" -> "\uf063"
        "night762" -> "\uf063"
        "night781" -> "\uf056"
        "night800" -> "\uf02e"
        "night801" -> "\uf022"
        "night802" -> "\uf022"
        "night803" -> "\uf022"
        "night804" -> "\uf086"
        "night900" -> "\uf056"
        "night902" -> "\uf073"
        "night903" -> "\uf076"
        "night904" -> "\uf072"
        "night906" -> "\uf024"
        "night957" -> "\uf050"
        else -> ""
    }

    enum class WeatherIconCode(val code: String){
        HUMIDITY("\uf07a"),
        THERMOMETER("\uF055"),
        WIND("\uF050")
    }

}
