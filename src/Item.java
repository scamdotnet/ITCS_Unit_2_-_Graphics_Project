import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Item extends JButton {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private String data;
    private final String name;
    private String type;
    private final Container container;
//    public Item() {
//        //I have no idea how the frick this is supposed to work, and I can't deal with figuring it out right now
//        //I need help
//        super("I am a button", new ImageIcon(("""
//                ‰PNG
//                \u001A
//                  \s
//                IHDR  \u0001   \u0001 \b\u0006   \\r¨f   \u0006bKGD ÿ ÿ ÿ ½§“  \u0011UIDATxœíÝ{°^UyÇñï›\u000B!7H \u0014…À\u0010\u0081„K\u001A´\bA\u0002DB\u0004\u00AD\t´"”\u0090ÚV\u0007K;‚(c°V;`µU\u0011/™Zo@\u0011D è\f^ZƒAZ4E¨`Á¤¥I\fB\u0018…\u0010£¹_IÎÛ?VNIŽçœ÷²žµŸ½÷ú}fž\u007FÎÌ>ï³×^ëy÷»÷^kƒˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆˆTWÃ;\u0001)…Ã€£€±À(`\f°\u001EØ
//                l\u0001V\u0001ÛÝ²“dT òs\b0\u0013˜\u0005œ
//                LÙû·Á4\u0081ÕÀ
//                àaàß€ÿ\u0004v§KSD¬\u001C\f\\\u0001,\u0001ö\u0010\u0006tll\u0002î f\u0003CŠÛ\u0015\u0011i×qÀÍÀ6l\u0006ý@ñ\u001Cð^`t1»%"ƒ9\u0006ø\u001Aá\u0014=åÀï\u001Bk\u0081ë€\u0003Òï¢ˆô5\u001C¸\u0006ØL±\u0003¿oü\f¸ ñ¾ŠÈ>N\u0004–â;ðûÆ—\u0081‘)wZDàmø\u007Fë\u000F\u0014O\u0001SÓíºH¾\u001AÀ
//                ø\u000FòV±\u0019xC¢6\u0010ÉÒPÂ)¶÷àn7v —&i\t‘Ì\f\u0001îÄ\u007FPw\u001A»\u0081·$h\u000F‘¬|\u001AÿÁÜmìD?\u0007Dºö^ü\u0007qll <‚,"\u001D8\u009Dð
//                ê=€-b\u0019aâ‘ˆ´a<ð,þ\u0003×2¾dÚB"5v3þ\u00036EÌ²l$éŒ¦\u0003WÃë€ÿ í¬»u„Gx{×\u0001\u0018\u000F\u001C\u000E\u001C\u000F\u001C˜ðs—\u0003§ »\u0012~†He5€Ÿ`ÿÍÛ\u0003<D˜&<i\u0090Ï\u001F\u0006L\u0007þ\u0016x&A\u001EM`A—m#R{s±\u001Fpß ¦u‘ËPà\u008F€•Æù¼ˆ.\bŠôëQì\u0006Ú\u000BÀ\u001B
//                r\u001A\u0001|\u0014»ÅEšÀ{\fò\u0012©•³°\u001B`?&ü¦·t\u0001v“\u0090V£•…DöcuåÿaÂBŸ)œ\u0081ÝŠCº# ²×HÂ\u0013s±ƒj%\u00AD\u0017ýŒ5\u008FpQ16×¯$ÎS¤2.$~@í\u0002^SP¾Ÿ0Èw#á®ƒHö\u0016\u0012? >^`¾#\b÷ôcs>£ÀœEJk\u0019ñß¦ã
//                Îy^dÎMàƒ\u0005ç,R:\u0007\u0013ÿ›ú“…g\u001Dž\u0013ˆ\u009D¯ðÝÂ³Î˜n»”Ó\u0014â\u001FÓ¾Ý"‘\u000Eí!,G\u001Eã\u0004‹DDªìOˆû\u0016]]|ÊÿïÌAòj'ö\u0090vî\u0081ìCg åôªÈí—˜dÑ\u009DÇ\bëÿuk\bƒÏM\u0010C* å\u0014{ñn¹I\u0016Ýy\tx:ò\u007F\u001Cl‘ˆ´¦\u0002PN±Oí½`’E÷ž\u008FÜ~¬I\u0016ÒRî\u000F]Œæå×c\u008FwÎe_±\u0017Â¶˜dÑ½Í‘ÛŸOñ·0\u0007²‹Ðž«\tw8jõJôÜ
//                @\u0003˜\t\\\u0002œKx\u009DV\u001Dõ8\u007FþžÈíßg’…½\u009D„Ù™\u000F w\u0011ÖG\u0090
//                \u0018\u0001\\\t¬"þA•*Ä%6ÍÖµ{ñoƒÔÑ\u0003,"ÌØ¬¬\u001C®\u0001Ì&<U÷EàXç\\¤>\u001A„µ\u0015– _\u0007ŽôM§;u. Ã\u0081O\u0001‹\tëÚ‰¤òVà§À\u001CïD:U×\u00020\u001Aø6p-ZøTŠq(¡Ï•õúE¿êx\u0011p\u0014p?\u0015ÿm&•Ô ÌÁ\u0018\u0002ÜèœK[êv\u00060\u0004¸\u001B
//                ~ñõqà\u008F½“hGÝ
//                À\u0002ÂB\u001A¹ó¾
//                Øtþ|o
//                ÂEç“¼\u0013i¥N\u0005`2ðaï$Jb\u00ADóç¯sþü2\u0018M˜‘Yê1Vêä:ôyÂýþÜõ\u0010Þðãi…óç—Åk\u0081·{'‘ƒ\u0019ø?\u0018R–x$²--LÂf‘Ð:ÄÏ\t·¤K©.g z©ÄËþÞ;\u0001Â#²÷x'Q\u0012“€‹¼“¨³C\bóÏ½+}\u0019âîÈ¶´t\u0004ðKüÛ¤\fñ\u009DÈ¶”A\\Šÿ\u0001.Cü\u000Bá]\u0002eò\u001AT\u0004š„\u0017§”r•£:ü\u0004x½w\u0002ÎÖ\u0013ž>»\u0010ØîœK_O §\u0011fÎyßšô4’ð†åÒ©Ãc²?\u0004ÎŽü\u001F/\u0002\u008F\u0013*u\u0015ì\u0002Ö\u0010.ø}\u000Fÿùÿí8†ð¦ãÉØ¿£0¥Ã\tƒ7ö\u000EÓÕÀçâÓ‘¾bO1ÿ•pÏVd '\u0011žmˆégŸ)<ëLl%îÀÔuQ\u0010±u=qýì¶âSn\u00AD\u000E× b/|é¡\u0015iGìB«¥<Ë¬C\u0001ˆ½Ž‘óÅ)i_-ûI\u001D
//                €ˆtI\u0005@$c* "\u0019S\u0001\u0010É˜
//                €HÆT D2¦\u0002 ’1\u0015 ‘Œ© ˆdL\u0005@$c* "\u0019S\u0001\u0010É˜
//                €HÆT D2¦\u0002 ’1\u0015 ‘Œ© ˆdL\u0005@$c* "\u0019S\u0001\u0010É˜
//                €HÆT D2¦\u0002 ’1\u0015 ‘Œ© ˆdL\u0005@$c* "\u0019S\u0001\u0010É˜
//                €HÆT D2¦\u0002 ’1\u0015 ‘Œ© ˆdl˜w\u0002m˜ œ\u0003L\u0005N ¦ ã\u0081qÀ\u0018Ç¼¤ºF Ó\u0081×\u0002“\t}êhB\u007F\u001A½7²PÖ\u0002p
//                0\u001F8\u001F˜\u00064|Ó‘\u001A8\f˜\u0007Ì\u0001f £|Ó‘¾F\u0001W\u0003O\u0002Í\u0002Cêí\u0002à[À.ŠíW}ãÞÔ;ZUc\u0081\u000F kñ90R?
//                à\u000F€Çð\u001Dô* -Ì\u0005žÃ÷ÀH½\u001C\u000F,Æ\u007FÀ« \fb"å9HR\u000FÃ€\u008Fà\u007Fª¯\u0002ÐÂl`
//                þ\u0007D\u0005 >&\u0002KðïK* -\\\u000Fôà\u007F0T êãl`\u001DþýH\u0005`\u0010C\u0081/à\u007F\u0010úÆÆ”;-ÉÍ\u0005¶áß\u008FÚ‰[\u0012µA”"ž\u0003\u0018
//                Ü\t\\VÀguê9ï\u0004¤kó€;(ï³,}eÛ×\u0016â_}\u0007ŠO%ÜoIg6°\u0003ÿþÓIœ‘¤%Jîzü\u001B~ Ø
//                œ”n×%‘Ó€-ø÷ŸNâ\t2œwóû”ï‚ß¾±0Ý®K"‡ «ñï;\u009D~ÑÌLÑ\u0018e6\u0011ø\u0015þ\u008D?P< \fO¶÷’B\u0003ø6þ}§“è\u0001®JÑ\u0018eW–‡|ú«Æ\u000BÑà¯¢?Ç¿ÿt\u0012k\u0081‹“´DÉ]†\u007Fãï\u001B›\u0081e„\u000B~úÍ_M‡\u0001¿Æ¿/µŠ5À\u000F€k\u0081ƒ’´DÉ\u001D\u0004<OšÆý
//                p;ðvÂ<î\tè›<\u0017·‘¦Oí\u0006¾\u0007, Î\u0005Ž$£µ Rø ö\u0007i)p9a\u0011\u0007ÉÏ\u0014Â@µþ2ù0ðŠ\u0002÷£öFa;¥w#p%\u0019Þ>‘ýX\u007Fûß
//                \u001CZè\u001Edâjì\u000EÒ“À±Å¦/%t\u0014v³û¶ o-6ý¼X\u00ADä³\u00048¸àÜ¥œ>ˆMŸZOX\u0003P\u00129\u0005»o~
//                ~éµ‚ø>µ\u009D0cP\u0012º‘ø\u0003µ\u0011\u009DöËËNÃæKå/‹N<G\u0016§ÿW\u0016žµ”Ù‡ˆïSß/<ë\fM ö\u0010w –¢«ý²¿\u0007‰ëS{€“\u000BÏ:Co!¾RÏ/<k)³\u0003\b¿ÝcúÔ}…g]A\u0016ßº¿\u001B¹ýzà\u001B\u0006yH}\u001C\u0007\u001C\u0018ù?n¶H¤î,
//                ÀäÈí¿\u0003ì4ÈCêcJäö›\b\u0013Ò¤\u0005‹\u0002\u0010{°\u001E2ÈAê%öKåaÂãÃÒ‚E\u0001˜\u0010¹ý2ƒ\u001C¤^bûÔR“,2`Q bßÐû¬A\u000ER/êS\u0005±( c#·ßd\u0090ƒÔKlŸÚl’E\u0006tï]$c\u0016\u0005 ¶Úf¹rŠ\f*¶OÅžAdÃ¢ l‰Üþ\u0018ƒ\u001C¤^Ô§
//                bQ ÖEn?Í \u0007©\u0017õ©‚X\u0014€\u0015‘Û¿Þ \u0007©—Ø>u\u0016Z/²-\u0016\u0005`eäösÐz\u007F²¿Ø>5\u00168ß"‘º³( ±\u000FòŒGK5ÉþV\u0011Þý\u0017ã\u009D\u0016‰Hk\u0016Ó\u0081—\u0011Þ",ÒëûÄõ©\u001Eâ'ªI›ž ~J°Vn‘}Y¬\u0007ø\u0003Â+Å$±O\u0010\u007F°6\u0012¦\u0081Š@xùKlŸj\u0002ï*:ñ\u001CMÃæ`-\u0005Æ\u0015œ»”×râûÔ\u000Eàœ¢\u0013Ï‘ÅÏ€&a*gìl0©\u0007ËeÁ³{EwÑ®Âæ`5\u0081gÐÃ\u001Cbûb\u0090]háÙ¤F\u0001/bW\u00046\u0013~¿éî@Þþ\t»>Õ$¼`ö°B÷ #ïÇö`5\u0081ÿ\u0006ÞFü\u001AqRM“±\u007F9è\u0006à£À\u0011\u0005îG\u0016Æ\u0002¿À¾\bô\u001E´;\u0081+€Ó\tUü€bvKœÝBš>µ›°üø_\u0001ç\u0011~rÄ.F’½KIs°º\u008D-„³ˆÏ\u0002S\u0013î·¤3\u00810AÈ»/µŠ5„w[¾\u008FÌ_qw?þ\u0007c Šÿ9tæPEWàß\u007F:‰u„/Ã,\u001D\t¬Åÿ \f\u0014\u000F¢"P5
//                à›ø÷\u009DN¢\u0007¸&EcTÁ\u001B‰Ÿ#\u00902þ!Ý®K"ã\t·ˆ½ûN'±\u001B87EcT\u0081Å\u000B\u001ES\u001E\u0018½;®zN%Ü"öî?\u009DÄOÉxýÍÏâ\u007F \u0006ŠO'ÜoIg\u0016á\u0011_ïþÓIœ™¤%*`\bp\u0017þ\u0007 ¿ÐKIªë2à%üûP»q}šf¨†\u0006áÛÖû ô
//                ½“ Úæ [ñïGíÄ\u00AD‰Ú R>Dù.\fJµÍ ÜwœzãÞT
//                P5³€\u0017ð? * õq8ð þ}I\u0005 MG\u0002‹ð?(* õ1\f¸\u0081ðªyï>¥\u0002Ð¦¹ÀjT ÄÎq”óIT\u0015€\u0001Œ\u0001\u0016\u0010ž£V\u0001\u0010+s\u0081Gñ\u001Fø* m\u001AI˜ÿÿ_¨ ˆ\u009DÙÀ}øÿ4P\u0001èÀTàcÀOH\u007F×@òp(á\u000Bf\u0011a†¨
//                 ÕX2ù\u0010Â¢Ž'\u0003'\u0002Söþm\u001CáçCì¤ž*´\u0081Ø\u001A\u000EL'<V|\u0002aÑ‘£\tý©7¬}\u009DŒg\u0007¦¤3 )Â%Ôð\f Û\t
//                "¢\u0002 ’5\u0015 ‘Œ© ˆdL\u0005@$c* "\u0019S\u0001\u0010É˜
//                €HÆT D2¦\u0002 ’1\u0015 ‘Œ© ˆdL\u0005@$c* "\u0019S\u0001\u0010É˜
//                €HÆT D2¦\u0002 ’1\u0015 ‘Œ© ˆdL\u0005@$c* "\u0019S\u0001\u0010É˜
//                €HÆT D2¦\u0002 ’1\u0015 ‘Œ© ˆdL\u0005@$c* "\u0019S\u0001\u0010É˜
//                €HÆT D2V‡\u0002ÐŒÜ~¨I\u0016Rwu\u0018+¿¥\u000E;µ-rû)&YHÝ\u009D\u0018¹ýV“,ŒÕ¡ lŒÜþ&`ŒE"R['\u0003WGþ\u008F
//                \u0016‰X\u001Bæ\u009D€\u0081§\u0081#"¶\u007FÓÞÿñ8%\u00ADÒýx\tX\u0003<
//                Ü\u000FlöM§-“€\u000B\u0081ã\u0081ßqÎ¥\u0013¯ ¦\u0003\u0007DþŸU\u0006¹H?þ‘p\u001D ×X\u000F\\Gy¯eL\u0004î\u0001zðo+Ï˜\u0019Û\u0090Ò¿Kð?¸eˆEÀ¨È¶´ö{Àóø·\u008Dwl\u0003FD¶¥\f`<°\u0003ÿƒ\\†øçÈ¶´4\u0011x\u0001ÿ6)C|+²-¥…{ñ?Èe‰‹"ÛÒÊ=ø·EYââÈ¶”\u0016ÎÄÿ —%\u001E‰lK\u000B“ÐoþÞxš\u0012_l¯Ãm@€\u001F\u0001‹½“(‰é„+×žæ\u0002
//                ç\u001CÊâ#Ànï$\u0006R—\u0002 p\u0015°Ó;‰\u0012hàÿpÓ\tÎŸ_\u0016\u008F\u0001wx'1˜:\u0015€Ÿ\u0001\u007Fã\u009DDILpþüC\u009D?¿\f¶\u0002\u007FJø)TZu* \u0010žê»Ï;‰\u0012ð>®¹Ÿþ7\u0081w\u0002ÿë\u009DH+Þ\u001DÅZ\u0013˜\u000F,ñND²ö~ànï$ÚQ·\u0002 °\u009Dðxï"ïD$;M`\u0001ðIïDÚUÇ\u0002 á÷×E„\u0003ÑtÎEò°\u000Ex3ágheÔµ @˜0s\u001Dp\u001E°Ü9\u0017©·{€iTð¬³Î\u0005 ×¿\u0003§\u0010.ÊhF–Xé\u0001¾\u000B¼\u000E˜Gxì¹rJû„’±]À-À\u00ADÀY„\tDç\u0011\u0016yÈýŠµ´o;a
//                öbà.à9ßtâåR z5\tw\bzï\u0012Œ\u0002&\u0013î›\u008F£<Åà\u001A`FÄöÞgv±S“o\u0002~l‘ˆ\u0081\u009D„õ\u0016Vï\u008D=¾éØÊ\u00AD ôµ
//                xÒ;‰~\\@\\\u0001ð^áhläö‹\u0081\u0007,\u0012‘Áy\u007FSHÿbWøy¥I\u0016Ý‹Y¡\t`“I\u0016Ò’
//                @9Å®s\u0018»€eŒáÀ±‘ÿC\u0005  * åôóÈíÏ6É¢;§\u0003\u0007Flß\u0003<c”‹´ \u0002PN±Ï-\u001C\u0005LµH¤\u000BoŽÜ~5a…')€
//                @9\u00AD þ\tÆ?³H¤CC\u0081Ë#ÿGé'Ðˆ\u0014a\u0019q+Ñl$ÜÚ,Òå‘97\u0081¿.8g‘RZHü`º±À|Gðò™KLL/0g‘Òº\u0090øÁ´\u000B8µ |{'^ÅÄ\u0006ôlŠ\b\u0010®¤¯'~P\u00AD"ý
//                =ó
//                òl\u0002·%ÎS¤R¾ŒÍÀú\u0011pP¢\u001CÏ$<Qi‘ç¬D9ŠTÒ\fl\u0006V\u0013x
//                8Î8¿ùØ
//                þgÑ])‘ßò\bvEà×À\u001Cƒœ\u000EÄæ7ÿ¾q\u008DA^"µ3\u0007Û\u0081Ö\u0004¾\t¼º‹\\zïó¯2Îg
//                å{¯¡H)4\bëË[\u0017\u0081\u001Eà‡À_0øOƒa„ßù\u007FGxJÏ:\u008F&pm—m#‘Ê2ÿ]\u00067\u009Dp!/åoäß +\tw\u001E¶\u0012\u001E"z%¡8¤|³íS„³‘—\u0012~†Hå}‘4ß¾Þ¡+ÿ"m\u0018G˜%ç=`-ã\u000B¦-$Rs§\u0011–¨ò\u001E¸\u0016±\u0014\u0018iÛ<"õ÷nü\u0007ol¬\u0007Ž·n\u0018‘\\Ü„ÿ î6¶\u0003çØ7‰H>\u001AÀWñ\u001FÌ\u009DÆnà\u000F\u0013´‡Hv†\u0002_Â\u007FP·\u001B;\bïc\u0010\u0011#
//                à\u0006ü\u0007w«X\u008FNûE’¹˜0—Þ{ ÷\u0017ÿ\u0003œ”n×E\u0004`
//                á%'Þ\u0003¾7z\b÷ùcV\b\u0016‘\u000E\f#ÌªÛ„ïà_\t¼!ñ¾ŠÈ Ž\u0002n'<__äÀ_C˜Ø3<ý.ŠH+¯"Ü)°Z´c x–pæ¡)½"%t\u0010ð\u000Eà!Â½x‹A¿\u0001ø
//                a2\u008FVò©(M\u0007ÎÏ8`&aàžJ¸x8¡Å6=„oùå„iÉ\u000F\u0002\u008F\u0013Š‰T˜
//                €@X5øhÂkÅÇ £\tßð›\u0081-„\u0015€vºe'""\"""\"""\"""\"""\"""\"""ýø?*¤\u0081}ßãÒ\u0012    IEND®B`‚""").getBytes()));
//        this.x = 100;
//        this.y = 100;
//        this.width = 200;
//        this.height = 200;
//
//        this.icon = new ImageIcon(iconToImage(getIcon()));
//        this.data = "Default data";
//        this.name = getText();
//        this.type = "text";
//        setBounds(x, y, width, height);
//    }


    public Item(int x, int y, int width, int height, ImageIcon icon, Container container, ActionListener actionListener) {
        //noinspection SuspiciousNameCombination
        super("Item", new ImageIcon(icon.getImage().getScaledInstance(width, width, java.awt.Image.SCALE_SMOOTH)));
        this.container = container;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.data = "data";
        this.name = this.getText();
        this.setBounds(x, y, width, height);
        this.setVerticalTextPosition(AbstractButton.BOTTOM);
        this.setHorizontalTextPosition(AbstractButton.CENTER);
        this.addActionListener(actionListener);
    }

    public Item(Icon icon, int x, int y, int width, int height, String data, String name, String type, Container container, ActionListener actionListener) {
        //noinspection SuspiciousNameCombination
        super("Item", new ImageIcon(iconToImage(icon).getScaledInstance(width, width, java.awt.Image.SCALE_SMOOTH)));
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.data = data;
        this.name = name;
        this.type = type;
        this.container = container;
        this.setBounds(x, y, width, height);
        this.setVerticalTextPosition(AbstractButton.BOTTOM);
        this.setHorizontalTextPosition(AbstractButton.CENTER);
        this.addActionListener(actionListener);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    static Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon)icon).getImage();
        }
        else {
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            BufferedImage image = gc.createCompatibleImage(w, h);
            Graphics2D g = image.createGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            return image;
        }
    }

}
