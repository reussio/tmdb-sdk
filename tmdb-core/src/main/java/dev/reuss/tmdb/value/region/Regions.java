package dev.reuss.tmdb.value.region;

import java.util.Set;

/**
 * Common ISO 3166-1 alpha-2 region constants for TMDB requests.
 *
 * <p>Each constant represents a two-letter country or territory code,
 * for example {@link #DE}, {@link #US}, {@link #GB} or {@link #BR}.</p>
 *
 * <p>This class is only a convenience holder. Custom regions can still
 * be created with {@link Region#of(String)} as long as they follow the
 * ISO 3166-1 alpha-2 format.</p>
 *
 * <p>If present, {@link #ALL} contains all region constants exposed by this
 * class as an immutable set.</p>
 *
 * @see Region
 * @see <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>
 * @see <a href="https://developer.themoviedb.org/docs/region-support">TMDB Regions</a>
 */
public final class Regions {

    public static final Region AF = Region.of("AF");
    public static final Region AX = Region.of("AX");
    public static final Region AL = Region.of("AL");
    public static final Region DZ = Region.of("DZ");
    public static final Region AS = Region.of("AS");
    public static final Region AD = Region.of("AD");
    public static final Region AO = Region.of("AO");
    public static final Region AI = Region.of("AI");
    public static final Region AQ = Region.of("AQ");
    public static final Region AG = Region.of("AG");
    public static final Region AR = Region.of("AR");
    public static final Region AM = Region.of("AM");
    public static final Region AW = Region.of("AW");
    public static final Region AU = Region.of("AU");
    public static final Region AT = Region.of("AT");
    public static final Region AZ = Region.of("AZ");
    public static final Region BS = Region.of("BS");
    public static final Region BH = Region.of("BH");
    public static final Region BD = Region.of("BD");
    public static final Region BB = Region.of("BB");
    public static final Region BY = Region.of("BY");
    public static final Region BE = Region.of("BE");
    public static final Region BZ = Region.of("BZ");
    public static final Region BJ = Region.of("BJ");
    public static final Region BM = Region.of("BM");
    public static final Region BT = Region.of("BT");
    public static final Region BO = Region.of("BO");
    public static final Region BQ = Region.of("BQ");
    public static final Region BA = Region.of("BA");
    public static final Region BW = Region.of("BW");
    public static final Region BV = Region.of("BV");
    public static final Region BR = Region.of("BR");
    public static final Region IO = Region.of("IO");
    public static final Region BN = Region.of("BN");
    public static final Region BG = Region.of("BG");
    public static final Region BF = Region.of("BF");
    public static final Region BI = Region.of("BI");
    public static final Region CV = Region.of("CV");
    public static final Region KH = Region.of("KH");
    public static final Region CM = Region.of("CM");
    public static final Region CA = Region.of("CA");
    public static final Region KY = Region.of("KY");
    public static final Region CF = Region.of("CF");
    public static final Region TD = Region.of("TD");
    public static final Region CL = Region.of("CL");
    public static final Region CN = Region.of("CN");
    public static final Region CX = Region.of("CX");
    public static final Region CC = Region.of("CC");
    public static final Region CO = Region.of("CO");
    public static final Region KM = Region.of("KM");
    public static final Region CG = Region.of("CG");
    public static final Region CD = Region.of("CD");
    public static final Region CK = Region.of("CK");
    public static final Region CR = Region.of("CR");
    public static final Region CI = Region.of("CI");
    public static final Region HR = Region.of("HR");
    public static final Region CU = Region.of("CU");
    public static final Region CW = Region.of("CW");
    public static final Region CY = Region.of("CY");
    public static final Region CZ = Region.of("CZ");
    public static final Region DK = Region.of("DK");
    public static final Region DJ = Region.of("DJ");
    public static final Region DM = Region.of("DM");
    public static final Region DO = Region.of("DO");
    public static final Region EC = Region.of("EC");
    public static final Region EG = Region.of("EG");
    public static final Region SV = Region.of("SV");
    public static final Region GQ = Region.of("GQ");
    public static final Region ER = Region.of("ER");
    public static final Region EE = Region.of("EE");
    public static final Region SZ = Region.of("SZ");
    public static final Region ET = Region.of("ET");
    public static final Region FK = Region.of("FK");
    public static final Region FO = Region.of("FO");
    public static final Region FJ = Region.of("FJ");
    public static final Region FI = Region.of("FI");
    public static final Region FR = Region.of("FR");
    public static final Region GF = Region.of("GF");
    public static final Region PF = Region.of("PF");
    public static final Region TF = Region.of("TF");
    public static final Region GA = Region.of("GA");
    public static final Region GM = Region.of("GM");
    public static final Region GE = Region.of("GE");
    public static final Region DE = Region.of("DE");
    public static final Region GH = Region.of("GH");
    public static final Region GI = Region.of("GI");
    public static final Region GR = Region.of("GR");
    public static final Region GL = Region.of("GL");
    public static final Region GD = Region.of("GD");
    public static final Region GP = Region.of("GP");
    public static final Region GU = Region.of("GU");
    public static final Region GT = Region.of("GT");
    public static final Region GG = Region.of("GG");
    public static final Region GN = Region.of("GN");
    public static final Region GW = Region.of("GW");
    public static final Region GY = Region.of("GY");
    public static final Region HT = Region.of("HT");
    public static final Region HM = Region.of("HM");
    public static final Region VA = Region.of("VA");
    public static final Region HN = Region.of("HN");
    public static final Region HK = Region.of("HK");
    public static final Region HU = Region.of("HU");
    public static final Region IS = Region.of("IS");
    public static final Region IN = Region.of("IN");
    public static final Region ID = Region.of("ID");
    public static final Region IR = Region.of("IR");
    public static final Region IQ = Region.of("IQ");
    public static final Region IE = Region.of("IE");
    public static final Region IM = Region.of("IM");
    public static final Region IL = Region.of("IL");
    public static final Region IT = Region.of("IT");
    public static final Region JM = Region.of("JM");
    public static final Region JP = Region.of("JP");
    public static final Region JE = Region.of("JE");
    public static final Region JO = Region.of("JO");
    public static final Region KZ = Region.of("KZ");
    public static final Region KE = Region.of("KE");
    public static final Region KI = Region.of("KI");
    public static final Region KP = Region.of("KP");
    public static final Region KR = Region.of("KR");
    public static final Region KW = Region.of("KW");
    public static final Region KG = Region.of("KG");
    public static final Region LA = Region.of("LA");
    public static final Region LV = Region.of("LV");
    public static final Region LB = Region.of("LB");
    public static final Region LS = Region.of("LS");
    public static final Region LR = Region.of("LR");
    public static final Region LY = Region.of("LY");
    public static final Region LI = Region.of("LI");
    public static final Region LT = Region.of("LT");
    public static final Region LU = Region.of("LU");
    public static final Region MO = Region.of("MO");
    public static final Region MG = Region.of("MG");
    public static final Region MW = Region.of("MW");
    public static final Region MY = Region.of("MY");
    public static final Region MV = Region.of("MV");
    public static final Region ML = Region.of("ML");
    public static final Region MT = Region.of("MT");
    public static final Region MH = Region.of("MH");
    public static final Region MQ = Region.of("MQ");
    public static final Region MR = Region.of("MR");
    public static final Region MU = Region.of("MU");
    public static final Region YT = Region.of("YT");
    public static final Region MX = Region.of("MX");
    public static final Region FM = Region.of("FM");
    public static final Region MD = Region.of("MD");
    public static final Region MC = Region.of("MC");
    public static final Region MN = Region.of("MN");
    public static final Region ME = Region.of("ME");
    public static final Region MS = Region.of("MS");
    public static final Region MA = Region.of("MA");
    public static final Region MZ = Region.of("MZ");
    public static final Region MM = Region.of("MM");
    public static final Region NA = Region.of("NA");
    public static final Region NR = Region.of("NR");
    public static final Region NP = Region.of("NP");
    public static final Region NL = Region.of("NL");
    public static final Region NC = Region.of("NC");
    public static final Region NZ = Region.of("NZ");
    public static final Region NI = Region.of("NI");
    public static final Region NE = Region.of("NE");
    public static final Region NG = Region.of("NG");
    public static final Region NU = Region.of("NU");
    public static final Region NF = Region.of("NF");
    public static final Region MK = Region.of("MK");
    public static final Region MP = Region.of("MP");
    public static final Region NO = Region.of("NO");
    public static final Region OM = Region.of("OM");
    public static final Region PK = Region.of("PK");
    public static final Region PW = Region.of("PW");
    public static final Region PS = Region.of("PS");
    public static final Region PA = Region.of("PA");
    public static final Region PG = Region.of("PG");
    public static final Region PY = Region.of("PY");
    public static final Region PE = Region.of("PE");
    public static final Region PH = Region.of("PH");
    public static final Region PN = Region.of("PN");
    public static final Region PL = Region.of("PL");
    public static final Region PT = Region.of("PT");
    public static final Region PR = Region.of("PR");
    public static final Region QA = Region.of("QA");
    public static final Region RE = Region.of("RE");
    public static final Region RO = Region.of("RO");
    public static final Region RU = Region.of("RU");
    public static final Region RW = Region.of("RW");
    public static final Region BL = Region.of("BL");
    public static final Region SH = Region.of("SH");
    public static final Region KN = Region.of("KN");
    public static final Region LC = Region.of("LC");
    public static final Region MF = Region.of("MF");
    public static final Region PM = Region.of("PM");
    public static final Region VC = Region.of("VC");
    public static final Region WS = Region.of("WS");
    public static final Region SM = Region.of("SM");
    public static final Region ST = Region.of("ST");
    public static final Region SA = Region.of("SA");
    public static final Region SN = Region.of("SN");
    public static final Region RS = Region.of("RS");
    public static final Region SC = Region.of("SC");
    public static final Region SL = Region.of("SL");
    public static final Region SG = Region.of("SG");
    public static final Region SX = Region.of("SX");
    public static final Region SK = Region.of("SK");
    public static final Region SI = Region.of("SI");
    public static final Region SB = Region.of("SB");
    public static final Region SO = Region.of("SO");
    public static final Region ZA = Region.of("ZA");
    public static final Region GS = Region.of("GS");
    public static final Region SS = Region.of("SS");
    public static final Region ES = Region.of("ES");
    public static final Region LK = Region.of("LK");
    public static final Region SD = Region.of("SD");
    public static final Region SR = Region.of("SR");
    public static final Region SJ = Region.of("SJ");
    public static final Region SE = Region.of("SE");
    public static final Region CH = Region.of("CH");
    public static final Region SY = Region.of("SY");
    public static final Region TW = Region.of("TW");
    public static final Region TJ = Region.of("TJ");
    public static final Region TZ = Region.of("TZ");
    public static final Region TH = Region.of("TH");
    public static final Region TL = Region.of("TL");
    public static final Region TG = Region.of("TG");
    public static final Region TK = Region.of("TK");
    public static final Region TO = Region.of("TO");
    public static final Region TT = Region.of("TT");
    public static final Region TN = Region.of("TN");
    public static final Region TR = Region.of("TR");
    public static final Region TM = Region.of("TM");
    public static final Region TC = Region.of("TC");
    public static final Region TV = Region.of("TV");
    public static final Region UG = Region.of("UG");
    public static final Region UA = Region.of("UA");
    public static final Region AE = Region.of("AE");
    public static final Region GB = Region.of("GB");
    public static final Region US = Region.of("US");
    public static final Region UM = Region.of("UM");
    public static final Region UY = Region.of("UY");
    public static final Region UZ = Region.of("UZ");
    public static final Region VU = Region.of("VU");
    public static final Region VE = Region.of("VE");
    public static final Region VN = Region.of("VN");
    public static final Region VG = Region.of("VG");
    public static final Region VI = Region.of("VI");
    public static final Region WF = Region.of("WF");
    public static final Region EH = Region.of("EH");
    public static final Region YE = Region.of("YE");
    public static final Region ZM = Region.of("ZM");
    public static final Region ZW = Region.of("ZW");

    /**
     * Immutable set containing all region constants exposed by this class.
     */
    public static final Set<Region> ALL = Set.of(
            AF, AX, AL, DZ, AS, AD, AO, AI, AQ, AG,
            AR, AM, AW, AU, AT, AZ, BS, BH, BD, BB,
            BY, BE, BZ, BJ, BM, BT, BO, BQ, BA, BW,
            BV, BR, IO, BN, BG, BF, BI, CV, KH, CM,
            CA, KY, CF, TD, CL, CN, CX, CC, CO, KM,
            CG, CD, CK, CR, CI, HR, CU, CW, CY, CZ,
            DK, DJ, DM, DO, EC, EG, SV, GQ, ER, EE,
            SZ, ET, FK, FO, FJ, FI, FR, GF, PF, TF,
            GA, GM, GE, DE, GH, GI, GR, GL, GD, GP,
            GU, GT, GG, GN, GW, GY, HT, HM, VA, HN,
            HK, HU, IS, IN, ID, IR, IQ, IE, IM, IL,
            IT, JM, JP, JE, JO, KZ, KE, KI, KP, KR,
            KW, KG, LA, LV, LB, LS, LR, LY, LI, LT,
            LU, MO, MG, MW, MY, MV, ML, MT, MH, MQ,
            MR, MU, YT, MX, FM, MD, MC, MN, ME, MS,
            MA, MZ, MM, NA, NR, NP, NL, NC, NZ, NI,
            NE, NG, NU, NF, MK, MP, NO, OM, PK, PW,
            PS, PA, PG, PY, PE, PH, PN, PL, PT, PR,
            QA, RE, RO, RU, RW, BL, SH, KN, LC, MF,
            PM, VC, WS, SM, ST, SA, SN, RS, SC, SL,
            SG, SX, SK, SI, SB, SO, ZA, GS, SS, ES,
            LK, SD, SR, SJ, SE, CH, SY, TW, TJ, TZ,
            TH, TL, TG, TK, TO, TT, TN, TR, TM, TC,
            TV, UG, UA, AE, GB, US, UM, UY, UZ, VU,
            VE, VN, VG, VI, WF, EH, YE, ZM, ZW
    );

    private Regions() {
    }
}
