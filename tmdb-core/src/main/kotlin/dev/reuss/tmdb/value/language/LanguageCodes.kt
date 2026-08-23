package dev.reuss.tmdb.value.language

import dev.reuss.tmdb.value.language.LanguageCodes.DE
import dev.reuss.tmdb.value.language.LanguageCodes.EN
import dev.reuss.tmdb.value.language.LanguageCodes.FR
import dev.reuss.tmdb.value.language.LanguageCodes.JA
import dev.reuss.tmdb.value.language.LanguageCodes.PT

/**
 * Common ISO 639-1 language code constants for TMDB requests.
 *
 * Each constant represents a two-letter language code,
 * for example [DE], [EN], [PT], [FR] or [JA].
 *
 * This object contains language codes only. For complete TMDB
 * language tags such as `de-DE` or `en-US`, use [Languages].
 *
 * This object is a convenience holder. Custom language codes can still
 * be created with [LanguageCode.of] as long as they follow ISO 639-1.
 *
 * See also the [ISO 639-1 code list](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes)
 * and the [TMDB language documentation](https://developer.themoviedb.org/docs/languages).
 *
 * @see LanguageCode
 * @see Language
 * @see Languages
 */
object LanguageCodes {
    @JvmField
    val AA = LanguageCode.of("aa")

    @JvmField
    val AB = LanguageCode.of("ab")

    @JvmField
    val AE = LanguageCode.of("ae")

    @JvmField
    val AF = LanguageCode.of("af")

    @JvmField
    val AK = LanguageCode.of("ak")

    @JvmField
    val AM = LanguageCode.of("am")

    @JvmField
    val AN = LanguageCode.of("an")

    @JvmField
    val AR = LanguageCode.of("ar")

    @JvmField
    val AS = LanguageCode.of("as")

    @JvmField
    val AV = LanguageCode.of("av")

    @JvmField
    val AY = LanguageCode.of("ay")

    @JvmField
    val AZ = LanguageCode.of("az")

    @JvmField
    val BA = LanguageCode.of("ba")

    @JvmField
    val BE = LanguageCode.of("be")

    @JvmField
    val BG = LanguageCode.of("bg")

    @JvmField
    val BH = LanguageCode.of("bh")

    @JvmField
    val BI = LanguageCode.of("bi")

    @JvmField
    val BM = LanguageCode.of("bm")

    @JvmField
    val BN = LanguageCode.of("bn")

    @JvmField
    val BO = LanguageCode.of("bo")

    @JvmField
    val BR = LanguageCode.of("br")

    @JvmField
    val BS = LanguageCode.of("bs")

    @JvmField
    val CA = LanguageCode.of("ca")

    @JvmField
    val CE = LanguageCode.of("ce")

    @JvmField
    val CH = LanguageCode.of("ch")

    @JvmField
    val CO = LanguageCode.of("co")

    @JvmField
    val CR = LanguageCode.of("cr")

    @JvmField
    val CS = LanguageCode.of("cs")

    @JvmField
    val CU = LanguageCode.of("cu")

    @JvmField
    val CV = LanguageCode.of("cv")

    @JvmField
    val CY = LanguageCode.of("cy")

    @JvmField
    val DA = LanguageCode.of("da")

    @JvmField
    val DE = LanguageCode.of("de")

    @JvmField
    val DV = LanguageCode.of("dv")

    @JvmField
    val DZ = LanguageCode.of("dz")

    @JvmField
    val EE = LanguageCode.of("ee")

    @JvmField
    val EL = LanguageCode.of("el")

    @JvmField
    val EN = LanguageCode.of("en")

    @JvmField
    val EO = LanguageCode.of("eo")

    @JvmField
    val ES = LanguageCode.of("es")

    @JvmField
    val ET = LanguageCode.of("et")

    @JvmField
    val EU = LanguageCode.of("eu")

    @JvmField
    val FA = LanguageCode.of("fa")

    @JvmField
    val FF = LanguageCode.of("ff")

    @JvmField
    val FI = LanguageCode.of("fi")

    @JvmField
    val FJ = LanguageCode.of("fj")

    @JvmField
    val FO = LanguageCode.of("fo")

    @JvmField
    val FR = LanguageCode.of("fr")

    @JvmField
    val FY = LanguageCode.of("fy")

    @JvmField
    val GA = LanguageCode.of("ga")

    @JvmField
    val GD = LanguageCode.of("gd")

    @JvmField
    val GL = LanguageCode.of("gl")

    @JvmField
    val GN = LanguageCode.of("gn")

    @JvmField
    val GU = LanguageCode.of("gu")

    @JvmField
    val GV = LanguageCode.of("gv")

    @JvmField
    val HA = LanguageCode.of("ha")

    @JvmField
    val HE = LanguageCode.of("he")

    @JvmField
    val HI = LanguageCode.of("hi")

    @JvmField
    val HO = LanguageCode.of("ho")

    @JvmField
    val HR = LanguageCode.of("hr")

    @JvmField
    val HT = LanguageCode.of("ht")

    @JvmField
    val HU = LanguageCode.of("hu")

    @JvmField
    val HY = LanguageCode.of("hy")

    @JvmField
    val HZ = LanguageCode.of("hz")

    @JvmField
    val IA = LanguageCode.of("ia")

    @JvmField
    val ID = LanguageCode.of("id")

    @JvmField
    val IE = LanguageCode.of("ie")

    @JvmField
    val IG = LanguageCode.of("ig")

    @JvmField
    val II = LanguageCode.of("ii")

    @JvmField
    val IK = LanguageCode.of("ik")

    @JvmField
    val IO = LanguageCode.of("io")

    @JvmField
    val IS = LanguageCode.of("is")

    @JvmField
    val IT = LanguageCode.of("it")

    @JvmField
    val IU = LanguageCode.of("iu")

    @JvmField
    val JA = LanguageCode.of("ja")

    @JvmField
    val JV = LanguageCode.of("jv")

    @JvmField
    val KA = LanguageCode.of("ka")

    @JvmField
    val KG = LanguageCode.of("kg")

    @JvmField
    val KI = LanguageCode.of("ki")

    @JvmField
    val KJ = LanguageCode.of("kj")

    @JvmField
    val KK = LanguageCode.of("kk")

    @JvmField
    val KL = LanguageCode.of("kl")

    @JvmField
    val KM = LanguageCode.of("km")

    @JvmField
    val KN = LanguageCode.of("kn")

    @JvmField
    val KO = LanguageCode.of("ko")

    @JvmField
    val KR = LanguageCode.of("kr")

    @JvmField
    val KS = LanguageCode.of("ks")

    @JvmField
    val KU = LanguageCode.of("ku")

    @JvmField
    val KV = LanguageCode.of("kv")

    @JvmField
    val KW = LanguageCode.of("kw")

    @JvmField
    val KY = LanguageCode.of("ky")

    @JvmField
    val LA = LanguageCode.of("la")

    @JvmField
    val LB = LanguageCode.of("lb")

    @JvmField
    val LG = LanguageCode.of("lg")

    @JvmField
    val LI = LanguageCode.of("li")

    @JvmField
    val LN = LanguageCode.of("ln")

    @JvmField
    val LO = LanguageCode.of("lo")

    @JvmField
    val LT = LanguageCode.of("lt")

    @JvmField
    val LU = LanguageCode.of("lu")

    @JvmField
    val LV = LanguageCode.of("lv")

    @JvmField
    val MG = LanguageCode.of("mg")

    @JvmField
    val MH = LanguageCode.of("mh")

    @JvmField
    val MI = LanguageCode.of("mi")

    @JvmField
    val MK = LanguageCode.of("mk")

    @JvmField
    val ML = LanguageCode.of("ml")

    @JvmField
    val MN = LanguageCode.of("mn")

    @JvmField
    val MR = LanguageCode.of("mr")

    @JvmField
    val MS = LanguageCode.of("ms")

    @JvmField
    val MT = LanguageCode.of("mt")

    @JvmField
    val MY = LanguageCode.of("my")

    @JvmField
    val NA = LanguageCode.of("na")

    @JvmField
    val NB = LanguageCode.of("nb")

    @JvmField
    val ND = LanguageCode.of("nd")

    @JvmField
    val NE = LanguageCode.of("ne")

    @JvmField
    val NG = LanguageCode.of("ng")

    @JvmField
    val NL = LanguageCode.of("nl")

    @JvmField
    val NN = LanguageCode.of("nn")

    @JvmField
    val NO = LanguageCode.of("no")

    @JvmField
    val NR = LanguageCode.of("nr")

    @JvmField
    val NV = LanguageCode.of("nv")

    @JvmField
    val NY = LanguageCode.of("ny")

    @JvmField
    val OC = LanguageCode.of("oc")

    @JvmField
    val OJ = LanguageCode.of("oj")

    @JvmField
    val OM = LanguageCode.of("om")

    @JvmField
    val OR = LanguageCode.of("or")

    @JvmField
    val OS = LanguageCode.of("os")

    @JvmField
    val PA = LanguageCode.of("pa")

    @JvmField
    val PI = LanguageCode.of("pi")

    @JvmField
    val PL = LanguageCode.of("pl")

    @JvmField
    val PS = LanguageCode.of("ps")

    @JvmField
    val PT = LanguageCode.of("pt")

    @JvmField
    val QU = LanguageCode.of("qu")

    @JvmField
    val RM = LanguageCode.of("rm")

    @JvmField
    val RN = LanguageCode.of("rn")

    @JvmField
    val RO = LanguageCode.of("ro")

    @JvmField
    val RU = LanguageCode.of("ru")

    @JvmField
    val RW = LanguageCode.of("rw")

    @JvmField
    val SA = LanguageCode.of("sa")

    @JvmField
    val SC = LanguageCode.of("sc")

    @JvmField
    val SD = LanguageCode.of("sd")

    @JvmField
    val SE = LanguageCode.of("se")

    @JvmField
    val SG = LanguageCode.of("sg")

    @JvmField
    val SI = LanguageCode.of("si")

    @JvmField
    val SK = LanguageCode.of("sk")

    @JvmField
    val SL = LanguageCode.of("sl")

    @JvmField
    val SM = LanguageCode.of("sm")

    @JvmField
    val SN = LanguageCode.of("sn")

    @JvmField
    val SO = LanguageCode.of("so")

    @JvmField
    val SQ = LanguageCode.of("sq")

    @JvmField
    val SR = LanguageCode.of("sr")

    @JvmField
    val SS = LanguageCode.of("ss")

    @JvmField
    val ST = LanguageCode.of("st")

    @JvmField
    val SU = LanguageCode.of("su")

    @JvmField
    val SV = LanguageCode.of("sv")

    @JvmField
    val SW = LanguageCode.of("sw")

    @JvmField
    val TA = LanguageCode.of("ta")

    @JvmField
    val TE = LanguageCode.of("te")

    @JvmField
    val TG = LanguageCode.of("tg")

    @JvmField
    val TH = LanguageCode.of("th")

    @JvmField
    val TI = LanguageCode.of("ti")

    @JvmField
    val TK = LanguageCode.of("tk")

    @JvmField
    val TL = LanguageCode.of("tl")

    @JvmField
    val TN = LanguageCode.of("tn")

    @JvmField
    val TO = LanguageCode.of("to")

    @JvmField
    val TR = LanguageCode.of("tr")

    @JvmField
    val TS = LanguageCode.of("ts")

    @JvmField
    val TT = LanguageCode.of("tt")

    @JvmField
    val TW = LanguageCode.of("tw")

    @JvmField
    val TY = LanguageCode.of("ty")

    @JvmField
    val UG = LanguageCode.of("ug")

    @JvmField
    val UK = LanguageCode.of("uk")

    @JvmField
    val UR = LanguageCode.of("ur")

    @JvmField
    val UZ = LanguageCode.of("uz")

    @JvmField
    val VE = LanguageCode.of("ve")

    @JvmField
    val VI = LanguageCode.of("vi")

    @JvmField
    val VO = LanguageCode.of("vo")

    @JvmField
    val WA = LanguageCode.of("wa")

    @JvmField
    val WO = LanguageCode.of("wo")

    @JvmField
    val XH = LanguageCode.of("xh")

    @JvmField
    val YI = LanguageCode.of("yi")

    @JvmField
    val YO = LanguageCode.of("yo")

    @JvmField
    val ZA = LanguageCode.of("za")

    @JvmField
    val ZH = LanguageCode.of("zh")

    @JvmField
    val ZU = LanguageCode.of("zu")

    /**
     * Immutable set containing all language code constants exposed by this object.
     */
    @JvmField
    val ALL: Set<LanguageCode> =
        setOf(
            AA,
            AB,
            AE,
            AF,
            AK,
            AM,
            AN,
            AR,
            AS,
            AV,
            AY,
            AZ,
            BA,
            BE,
            BG,
            BH,
            BI,
            BM,
            BN,
            BO,
            BR,
            BS,
            CA,
            CE,
            CH,
            CO,
            CR,
            CS,
            CU,
            CV,
            CY,
            DA,
            DE,
            DV,
            DZ,
            EE,
            EL,
            EN,
            EO,
            ES,
            ET,
            EU,
            FA,
            FF,
            FI,
            FJ,
            FO,
            FR,
            FY,
            GA,
            GD,
            GL,
            GN,
            GU,
            GV,
            HA,
            HE,
            HI,
            HO,
            HR,
            HT,
            HU,
            HY,
            HZ,
            IA,
            ID,
            IE,
            IG,
            II,
            IK,
            IO,
            IS,
            IT,
            IU,
            JA,
            JV,
            KA,
            KG,
            KI,
            KJ,
            KK,
            KL,
            KM,
            KN,
            KO,
            KR,
            KS,
            KU,
            KV,
            KW,
            KY,
            LA,
            LB,
            LG,
            LI,
            LN,
            LO,
            LT,
            LU,
            LV,
            MG,
            MH,
            MI,
            MK,
            ML,
            MN,
            MR,
            MS,
            MT,
            MY,
            NA,
            NB,
            ND,
            NE,
            NG,
            NL,
            NN,
            NO,
            NR,
            NV,
            NY,
            OC,
            OJ,
            OM,
            OR,
            OS,
            PA,
            PI,
            PL,
            PS,
            PT,
            QU,
            RM,
            RN,
            RO,
            RU,
            RW,
            SA,
            SC,
            SD,
            SE,
            SG,
            SI,
            SK,
            SL,
            SM,
            SN,
            SO,
            SQ,
            SR,
            SS,
            ST,
            SU,
            SV,
            SW,
            TA,
            TE,
            TG,
            TH,
            TI,
            TK,
            TL,
            TN,
            TO,
            TR,
            TS,
            TT,
            TW,
            TY,
            UG,
            UK,
            UR,
            UZ,
            VE,
            VI,
            VO,
            WA,
            WO,
            XH,
            YI,
            YO,
            ZA,
            ZH,
            ZU,
        )
}
