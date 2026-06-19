package dev.reuss.tmdb.value.language;

/**
 * Common ISO 639-1 language code constants for TMDB requests.
 *
 * <p>Each constant represents a two-letter language code,
 * for example {@link #DE}, {@link #EN}, {@link #PT}, {@link #FR}
 * or {@link #JA}.</p>
 *
 * <p>This class contains language codes only. For complete TMDB
 * language tags such as {@code de-DE} or {@code en-US}, use
 * {@link Languages}.</p>
 *
 * <p>This class is a convenience holder. Custom language codes can still
 * be created with {@link LanguageCode#of(String)} as long as they follow
 * ISO 639-1.</p>
 *
 * @see LanguageCode
 * @see Language
 * @see Languages
 * @see <a href="https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes">ISO 639-1</a>
 * @see <a href="https://developer.themoviedb.org/docs/languages">TMDB Languages</a>
 */
public final class LanguageCodes {

    public static final LanguageCode AA = LanguageCode.of("aa");
    public static final LanguageCode AB = LanguageCode.of("ab");
    public static final LanguageCode AE = LanguageCode.of("ae");
    public static final LanguageCode AF = LanguageCode.of("af");
    public static final LanguageCode AK = LanguageCode.of("ak");
    public static final LanguageCode AM = LanguageCode.of("am");
    public static final LanguageCode AN = LanguageCode.of("an");
    public static final LanguageCode AR = LanguageCode.of("ar");
    public static final LanguageCode AS = LanguageCode.of("as");
    public static final LanguageCode AV = LanguageCode.of("av");
    public static final LanguageCode AY = LanguageCode.of("ay");
    public static final LanguageCode AZ = LanguageCode.of("az");
    public static final LanguageCode BA = LanguageCode.of("ba");
    public static final LanguageCode BE = LanguageCode.of("be");
    public static final LanguageCode BG = LanguageCode.of("bg");
    public static final LanguageCode BH = LanguageCode.of("bh");
    public static final LanguageCode BI = LanguageCode.of("bi");
    public static final LanguageCode BM = LanguageCode.of("bm");
    public static final LanguageCode BN = LanguageCode.of("bn");
    public static final LanguageCode BO = LanguageCode.of("bo");
    public static final LanguageCode BR = LanguageCode.of("br");
    public static final LanguageCode BS = LanguageCode.of("bs");
    public static final LanguageCode CA = LanguageCode.of("ca");
    public static final LanguageCode CE = LanguageCode.of("ce");
    public static final LanguageCode CH = LanguageCode.of("ch");
    public static final LanguageCode CO = LanguageCode.of("co");
    public static final LanguageCode CR = LanguageCode.of("cr");
    public static final LanguageCode CS = LanguageCode.of("cs");
    public static final LanguageCode CU = LanguageCode.of("cu");
    public static final LanguageCode CV = LanguageCode.of("cv");
    public static final LanguageCode CY = LanguageCode.of("cy");
    public static final LanguageCode DA = LanguageCode.of("da");
    public static final LanguageCode DE = LanguageCode.of("de");
    public static final LanguageCode DV = LanguageCode.of("dv");
    public static final LanguageCode DZ = LanguageCode.of("dz");
    public static final LanguageCode EE = LanguageCode.of("ee");
    public static final LanguageCode EL = LanguageCode.of("el");
    public static final LanguageCode EN = LanguageCode.of("en");
    public static final LanguageCode EO = LanguageCode.of("eo");
    public static final LanguageCode ES = LanguageCode.of("es");
    public static final LanguageCode ET = LanguageCode.of("et");
    public static final LanguageCode EU = LanguageCode.of("eu");
    public static final LanguageCode FA = LanguageCode.of("fa");
    public static final LanguageCode FF = LanguageCode.of("ff");
    public static final LanguageCode FI = LanguageCode.of("fi");
    public static final LanguageCode FJ = LanguageCode.of("fj");
    public static final LanguageCode FO = LanguageCode.of("fo");
    public static final LanguageCode FR = LanguageCode.of("fr");
    public static final LanguageCode FY = LanguageCode.of("fy");
    public static final LanguageCode GA = LanguageCode.of("ga");
    public static final LanguageCode GD = LanguageCode.of("gd");
    public static final LanguageCode GL = LanguageCode.of("gl");
    public static final LanguageCode GN = LanguageCode.of("gn");
    public static final LanguageCode GU = LanguageCode.of("gu");
    public static final LanguageCode GV = LanguageCode.of("gv");
    public static final LanguageCode HA = LanguageCode.of("ha");
    public static final LanguageCode HE = LanguageCode.of("he");
    public static final LanguageCode HI = LanguageCode.of("hi");
    public static final LanguageCode HO = LanguageCode.of("ho");
    public static final LanguageCode HR = LanguageCode.of("hr");
    public static final LanguageCode HT = LanguageCode.of("ht");
    public static final LanguageCode HU = LanguageCode.of("hu");
    public static final LanguageCode HY = LanguageCode.of("hy");
    public static final LanguageCode HZ = LanguageCode.of("hz");
    public static final LanguageCode IA = LanguageCode.of("ia");
    public static final LanguageCode ID = LanguageCode.of("id");
    public static final LanguageCode IE = LanguageCode.of("ie");
    public static final LanguageCode IG = LanguageCode.of("ig");
    public static final LanguageCode II = LanguageCode.of("ii");
    public static final LanguageCode IK = LanguageCode.of("ik");
    public static final LanguageCode IO = LanguageCode.of("io");
    public static final LanguageCode IS = LanguageCode.of("is");
    public static final LanguageCode IT = LanguageCode.of("it");
    public static final LanguageCode IU = LanguageCode.of("iu");
    public static final LanguageCode JA = LanguageCode.of("ja");
    public static final LanguageCode JV = LanguageCode.of("jv");
    public static final LanguageCode KA = LanguageCode.of("ka");
    public static final LanguageCode KG = LanguageCode.of("kg");
    public static final LanguageCode KI = LanguageCode.of("ki");
    public static final LanguageCode KJ = LanguageCode.of("kj");
    public static final LanguageCode KK = LanguageCode.of("kk");
    public static final LanguageCode KL = LanguageCode.of("kl");
    public static final LanguageCode KM = LanguageCode.of("km");
    public static final LanguageCode KN = LanguageCode.of("kn");
    public static final LanguageCode KO = LanguageCode.of("ko");
    public static final LanguageCode KR = LanguageCode.of("kr");
    public static final LanguageCode KS = LanguageCode.of("ks");
    public static final LanguageCode KU = LanguageCode.of("ku");
    public static final LanguageCode KV = LanguageCode.of("kv");
    public static final LanguageCode KW = LanguageCode.of("kw");
    public static final LanguageCode KY = LanguageCode.of("ky");
    public static final LanguageCode LA = LanguageCode.of("la");
    public static final LanguageCode LB = LanguageCode.of("lb");
    public static final LanguageCode LG = LanguageCode.of("lg");
    public static final LanguageCode LI = LanguageCode.of("li");
    public static final LanguageCode LN = LanguageCode.of("ln");
    public static final LanguageCode LO = LanguageCode.of("lo");
    public static final LanguageCode LT = LanguageCode.of("lt");
    public static final LanguageCode LU = LanguageCode.of("lu");
    public static final LanguageCode LV = LanguageCode.of("lv");
    public static final LanguageCode MG = LanguageCode.of("mg");
    public static final LanguageCode MH = LanguageCode.of("mh");
    public static final LanguageCode MI = LanguageCode.of("mi");
    public static final LanguageCode MK = LanguageCode.of("mk");
    public static final LanguageCode ML = LanguageCode.of("ml");
    public static final LanguageCode MN = LanguageCode.of("mn");
    public static final LanguageCode MR = LanguageCode.of("mr");
    public static final LanguageCode MS = LanguageCode.of("ms");
    public static final LanguageCode MT = LanguageCode.of("mt");
    public static final LanguageCode MY = LanguageCode.of("my");
    public static final LanguageCode NA = LanguageCode.of("na");
    public static final LanguageCode NB = LanguageCode.of("nb");
    public static final LanguageCode ND = LanguageCode.of("nd");
    public static final LanguageCode NE = LanguageCode.of("ne");
    public static final LanguageCode NG = LanguageCode.of("ng");
    public static final LanguageCode NL = LanguageCode.of("nl");
    public static final LanguageCode NN = LanguageCode.of("nn");
    public static final LanguageCode NO = LanguageCode.of("no");
    public static final LanguageCode NR = LanguageCode.of("nr");
    public static final LanguageCode NV = LanguageCode.of("nv");
    public static final LanguageCode NY = LanguageCode.of("ny");
    public static final LanguageCode OC = LanguageCode.of("oc");
    public static final LanguageCode OJ = LanguageCode.of("oj");
    public static final LanguageCode OM = LanguageCode.of("om");
    public static final LanguageCode OR = LanguageCode.of("or");
    public static final LanguageCode OS = LanguageCode.of("os");
    public static final LanguageCode PA = LanguageCode.of("pa");
    public static final LanguageCode PI = LanguageCode.of("pi");
    public static final LanguageCode PL = LanguageCode.of("pl");
    public static final LanguageCode PS = LanguageCode.of("ps");
    public static final LanguageCode PT = LanguageCode.of("pt");
    public static final LanguageCode QU = LanguageCode.of("qu");
    public static final LanguageCode RM = LanguageCode.of("rm");
    public static final LanguageCode RN = LanguageCode.of("rn");
    public static final LanguageCode RO = LanguageCode.of("ro");
    public static final LanguageCode RU = LanguageCode.of("ru");
    public static final LanguageCode RW = LanguageCode.of("rw");
    public static final LanguageCode SA = LanguageCode.of("sa");
    public static final LanguageCode SC = LanguageCode.of("sc");
    public static final LanguageCode SD = LanguageCode.of("sd");
    public static final LanguageCode SE = LanguageCode.of("se");
    public static final LanguageCode SG = LanguageCode.of("sg");
    public static final LanguageCode SI = LanguageCode.of("si");
    public static final LanguageCode SK = LanguageCode.of("sk");
    public static final LanguageCode SL = LanguageCode.of("sl");
    public static final LanguageCode SM = LanguageCode.of("sm");
    public static final LanguageCode SN = LanguageCode.of("sn");
    public static final LanguageCode SO = LanguageCode.of("so");
    public static final LanguageCode SQ = LanguageCode.of("sq");
    public static final LanguageCode SR = LanguageCode.of("sr");
    public static final LanguageCode SS = LanguageCode.of("ss");
    public static final LanguageCode ST = LanguageCode.of("st");
    public static final LanguageCode SU = LanguageCode.of("su");
    public static final LanguageCode SV = LanguageCode.of("sv");
    public static final LanguageCode SW = LanguageCode.of("sw");
    public static final LanguageCode TA = LanguageCode.of("ta");
    public static final LanguageCode TE = LanguageCode.of("te");
    public static final LanguageCode TG = LanguageCode.of("tg");
    public static final LanguageCode TH = LanguageCode.of("th");
    public static final LanguageCode TI = LanguageCode.of("ti");
    public static final LanguageCode TK = LanguageCode.of("tk");
    public static final LanguageCode TL = LanguageCode.of("tl");
    public static final LanguageCode TN = LanguageCode.of("tn");
    public static final LanguageCode TO = LanguageCode.of("to");
    public static final LanguageCode TR = LanguageCode.of("tr");
    public static final LanguageCode TS = LanguageCode.of("ts");
    public static final LanguageCode TT = LanguageCode.of("tt");
    public static final LanguageCode TW = LanguageCode.of("tw");
    public static final LanguageCode TY = LanguageCode.of("ty");
    public static final LanguageCode UG = LanguageCode.of("ug");
    public static final LanguageCode UK = LanguageCode.of("uk");
    public static final LanguageCode UR = LanguageCode.of("ur");
    public static final LanguageCode UZ = LanguageCode.of("uz");
    public static final LanguageCode VE = LanguageCode.of("ve");
    public static final LanguageCode VI = LanguageCode.of("vi");
    public static final LanguageCode VO = LanguageCode.of("vo");
    public static final LanguageCode WA = LanguageCode.of("wa");
    public static final LanguageCode WO = LanguageCode.of("wo");
    public static final LanguageCode XH = LanguageCode.of("xh");
    public static final LanguageCode YI = LanguageCode.of("yi");
    public static final LanguageCode YO = LanguageCode.of("yo");
    public static final LanguageCode ZA = LanguageCode.of("za");
    public static final LanguageCode ZH = LanguageCode.of("zh");
    public static final LanguageCode ZU = LanguageCode.of("zu");

    private LanguageCodes() {
    }
}
