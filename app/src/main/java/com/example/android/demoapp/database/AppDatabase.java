package com.example.android.demoapp.database;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.android.demoapp.AppExecutors;
import com.example.android.demoapp.R;


@Database(entities = {SanPhamEntry.class, GioHangEntry.class, YeuThichEntry.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "demoapp";
    private static AppDatabase sInstance;

    public synchronized static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = buildDatabase(context);
            }
        }
        return sInstance;
    }

    private static AppDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class,
                AppDatabase.DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        AppExecutors.getInstance().diskIO().execute(new Runnable() {
                            @Override
                            public void run() {
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Cốm dẹp lá dứa", 2.50, R.drawable.a1, "300g", "Cốm dẹp lá dứa là đồ ăn được làm từ lúa nếp bằng cách rang và sàng sảy cho hết vỏ trấu, là món ăn rất thịnh hành trong ẩm thực đồng bằng Bắc Bộ, đặc biệt là tại Hà Nội. Cốm có chứa chất xơ, protein, vitamin... giúp bạn phòng cao huyết áp và bệnh tim mạch, ngừa bệnh đường ruột và táo bón, đồng thời giúp tăng chiều cao ", "Gia Bao", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Lạc nhân vỏ hồng", 2.50, R.drawable.a2, "400g", "Lạc chứa các chất đạm, béo, amino acid, lecithin, purine, canxi, phosphore, sắt. Chất lysine trong hạt lạc có tác dụng phòng ngừa lão hóa sớm và giúp tăng trí tuệ của trẻ em. Acid glutamic và acid aspartic thúc đẩy sự phát triển tế bào não và tăng cường trí nhớ. Ngoài ra chất catechin trong lạc cũng có tác dụng chống lão hóa. ", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Bánh tráng cuốn Mỹ Tho", 2.20, R.drawable.a3, "400g", "Bánh tráng đặc sản Mỹ Tho chuyên dùng cho món gỏi cuốn truyền thống của người Việt, bánh tròn, dày, dai k bở.", "Ba Cây Tre", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Đỗ xanh không vỏ", 1.80, R.drawable.a4, "400g", "Sản phẩm làm từ 100% đậu xanh không vỏ nguyên chất, không chứa chất bảo quản. Công dụng đỗ xanh: dùng để nấu chè, làm nhân bánh da lợn, chả chay, nấu cháo...", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Bánh tráng rán Mỹ Tho", 2.50, R.drawable.a5, "400g", "Bánh tráng đặc sản Mỹ Tho chuyên dùng cho món nem rán truyền thống của người Việt, bánh tròn, dày, dai k bở.", "Ba Cây Tre", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Bánh phồng tôm Sa Giang", 4.20, R.drawable.a6, "1kg", "Sản phẩm bánh phồng tôm Sa Giang của Công ty đã nổi tiếng tại Việt Nam từ những năm 1960. Từ các loại tôm nước ngọt, nước mặn như tôm tích, tôm sắt, tôm bạc, tôm nghệ, tôm sú… qua bàn tay chế biến khéo léo của con người đã mang lại hương vị đặc trưng của bánh phồng tôm Sa Giang.", "Sa Giang", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0," Cà phê hòa tan G7", 3.19, R.drawable.a7, "20 gói", "Cà phê hòa tan G7 3in1 Trung Nguyên là cafe sữa hòa tan hội tụ những yếu tố đặc biệt nhất thế giới cùng với nguyên liệu tốt nhất, công nghệ sản xuất hiện đại, bí quyết Phương Đông độc đáo.", "Trung Nguyen", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Long nhãn sấy", 3.60, R.drawable.a8, "100g", "Nhờ thành phần dưỡng chất độc đáo, chứa nhiều chất có lợi cho sức khỏe long nhãn được coi như “thuốc bổ của mọi nhà”. Long nhãn chứa protid, magie, sắt, vitamin A, B & C và các hợp chất acid amin… -  giúp an thần, bổ máu, bổ khí huyết, tăng cường sức khỏe và sinh lý nam giới. Trong đông y, long nhãn có vị ngọt, tính bình, ấm, có tác dụng bổ tâm tỳ, an thần, lợi khí, dưỡng huyết, trị suy giảm trí nhớ, chữa hay quên, rối loạn giấc ngủ, lo âu, thiếu máu, mệt mỏi, suy nhược cơ thể, tim đập nhanh.", "Lucky food", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Rong biển cuốn Sushi", 12.00, R.drawable.a9, "140g", "Rong biển là loại thực phẩm rất giàu các chất dinh dưỡng, chất đạm và chất khoáng, với hàm lượng vitamin cao gấp nhiều lần so với các loại thực phẩm thực vật khác. Rong biển có nhiều tác dụng tốt cho cơ thể như giảm cholesterol, diệt khuẩn, lọc máu, ngừa táo bón,...Rong Biển Khô được làm từ nguồn nguyên liệu rong biển chọn lọc, nguyên chất, sử dụng để chế biến thành nhiều món ăn bổ dưỡng và ngon miệng trong gia đình như: cơm cuộn, canh rong biển,...", "Yamaki", "Hàn Quốc"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(0,"Nấm hương Omeli", 2.99, R.drawable.a10, "100g", "Nấm hương chứa khá nhiều đạm và đặc biệt giàu khoáng chất, vitamin như vitamin C, B, tiền vitamin D, canxi, Niacin, nhôm, sắt, magiê... Nó có khoảng 30 enzym và tất cả các acid amin tối cần thiết cho cơ thể (những acid amin mà cơ thể không tổng hợp được). Một nghiên cứu tại Nhật cho thấy, những bệnh nhân ung thư đang hóa trị nếu dùng thêm Lentinan từ nấm hương thì hiệu quả hóa trị sẽ tăng lên, khả năng sống sót cao hơn và sự tiến triển của ung thư sẽ bị kìm hãm. Vì vậy ở Nhật, Lentinan đã được chấp nhận như một liệu pháp phụ trợ trong tiến trình dùng hóa trị liệu.", "Omeli", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Thịt ốc bươu", 3.80, R.drawable.a11, "450g", "Ốc bươu là món ăn dân dã, quen thuộc và rất ngon miệng ở Việt Nam. Ở khu vực phía Bắc có món bún riêu ốc, ốc chuối đậu, ốc luộc lá chanh, . ốc bưu nhồi thịt mang hương vị đặc trưng …. ở vùng Nam Bộ có món ốc hấp tiêu, ốc bươu hấp chấm với nước mắm gừng đặc biệt thơm ngon.", "Asian Pearl", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Chân gà đông đá", 5.50, R.drawable.a12, "1kg", "Được rất nhiều người yêu thích, chân gà được chế biến thành nhiều món ăn hấp dẫn khác nhau như chân gà rang muối, chân gà ngâm sả tắc ", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Cá bông lau", 6.00, R.drawable.a13, "850g", "Cá bông lau là loài cá có nhiều chất dinh dưỡng vô cùng tốt cho sức khỏe của con người.Trong hàm lượng thịt của cá bông lau chứa rất nhiều protein, chất đạm, DHA, giàu khoáng chất và cung cấp rất nhiều sắt. Chính vì hàm lượng chất dinh dưỡng trong thịt cá cao, cá bông lau được đánh bắt tự nhiên còn được mệnh danh là “nhân sâm nước”.Cá bông lau có những tác dụng đối với con người: tốt cho những người bị suy nhược, trẻ nhỏ bị suy dinh dưỡng, phụ nữ đang mang thai, người gầy ốm và kén ăn.", "Asian Pearl", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Mực Mỹ", 10.00, R.drawable.a14, "1kg", "Mực là món ăn rất bổ dưỡng và có thể được chế biến rất nhiều món phổ biến nhất là xào, nướng và hấp.", "Del Mar Seafoods", "Mỹ"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Tôm thẻ nguyên con", 11.50, R.drawable.a15, "1kg", "Tôm có canxi chủ yếu từ thịt, chân và càng rất có lợi cho xương, đặc biệt là trẻ em.Tôm chứa nhiều axit béo omega, những axit béo này mang lại nhiều lợi ích cho não và tăng cường phát triển thị giác ở trẻ sơ sinh. Do vậy, đưa tôm vào chế độ dinh dưỡng hàng ngày là việc làm quan trọng đối với phụ nữ có thai, đang cho con bú và người đang trong độ tuổi sinh sản.", "Ecuagold", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Đùi ếch", 12.00, R.drawable.a16, "1kg", "Ếch là một trong những thực phẩm bổ dưỡng được nhiều người ưa thích.Thịt ếch có màu trắng, nạc, ngon như thịt gà với thành phần dinh dưỡng phong phú như protein, chất béo, đường, canxi, phốt pho, kali, natri, sắt, đồng… cung cấp đủ chất dinh dưỡng cho cơ thể, đặc biệt là giúp trẻ suy dinh dưỡng tăng cân nhanh hơn", "Asian Pearl", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Cá diêu hồng", 6.50, R.drawable.a17, "800g", "Cá diêu hồng là loài cá có thịt trắng ngon, lành tính. Thịt cá diêu hồng có vị ngọt, tính bình, không độc, tác dụng bổ khí huyết, ích tỳ vị, lợi ngũ tạng...", "Asian Pearl", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Trái sấu đông lạnh", 4.80, R.drawable.a18, "500g", "Sấu tươi đông lạnh có thể nấu được các món ăn giải nhiệt, dân dã nhưng không thể nào quên như canh sấu rau muống, canh sấu sườn non, vịt om sấu, hoặc các món giải khát như sấu ngâm đường…Chỉ nghĩ đến thôi cũng làm cho những người sinh ra và lớn lên có tuổi thơ ở Bắc cũng phải phát thèm.", "Asian Pearl", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Nghêu lụa vàng", 4.20, R.drawable.a19, "500g", "Thịt nghêu có đầy đủ các chất dinh dưỡng quan trọng và các vitamin tổng hợp tự nhiên: selen, mangan, vitamin C, B 12, đồng, phốt pho, và riboflavin và sắtgiúp tăng khả năng miễn dịch và giảm cholesterol xấu", "Asian Pearl", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(1,"Tép đồng", 4.00, R.drawable.a20, "250g", "  Là một món ăn dẫn dã quen thuộc, đặc biệt với người dân vùng đống quê, tép đồng được đánh giá là 1 món ăn rất giàu dinh dưỡng và dễ chế biến và rất tốt cho sức khỏe. ", "Ja Asian", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Rau húng quế", 2.40, R.drawable.a21, "100g", "Húng quế là loại rau gia vị rất quen thuộc còn được gọi với tên rất phổ biến khác là húng chó. Đây cũng chính là một loại dược liệu có tác dụng dược lý đa dạng nhờ hàm lượng tinh dầu cao. Thường dùng làm vị thuốc chữa các triệu chứng liên quan đến bệnh đường hô hấp, mề đay mẩn ngứa, đau dạ dày, viêm ruột, đầy bụng…", "Achau24", "Thái Lan"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Lá lốt", 2.50, R.drawable.a22, "100g", "Lá lốt là một loại rau quen thuộc với nhiều người và được dùng dùng phổ biến trong các món ăn rất ngon. Ngoài công dụng làm rau ăn, nó còn có những tác dụng rất tuyệt vời như tăng cường sinh lý nam giới, tăng tiết sữa mẹ, điều trị tàn nhang... ", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Tía tô", 2.35, R.drawable.a23, "100g", "Lá tía tô từ lâu đã là một loại gia vị quen thuộc trong bữa ăn hằng ngày của gia đình Việt. Ngoài công dụng chính là nấu ăn thì loài cây này còn được biết đến là một loại thảo dược chữa bệnh và làm đẹp hiệu quả. Lá tía tô giúp giải cảm, giảm tình trạng đau dạ dày, ngăn ngừa bệnh tim, hỗ trợ chữa bệnh gút và viêm khớp dạng thấp.", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Cải canh ", 1.70, R.drawable.a24, "300g", "Rau cải canh có vị cay rất đặc trưng, thường được dùng để muối chua, nấu canh hoặc ăn sống kèm với bánh xèo. Ngoài ra, thực phẩm này còn có nhiều công dụng đối với sức khỏe và được sử dụng làm thuốc chữa bệnh.  Cải canh giảm cholesterol, bảo vệ sức khỏe tim mạch, chữa ho kéo dài, ho khan, ho có đờm, phòng ngừa và hỗ trợ điều trị bệnh gout...", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Ớt hiểm đỏ ", 2.20, R.drawable.a25, "100g", "Ớt hiểm đỏ được sử dụng rất phổ biến trong nền ẩm thực Đông Nam Á. Đối với ẩm thực Việt Nam, ớt hiểm đỏ thường được sử dụng để tăng hương vị cho các món canh, món xào, trộn, nộm, gỏi. Loại quả này cũng được dùng để pha nước mắm, nước tương hoặc ăn sống", "Achau24", "Thái Lan"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Rau cải ngồng", 1.70, R.drawable.a26, "300g", "Trong cải Ngồng rất giàu khoáng chất các vitamin A, B, C, chất beta caroten chống oxy hóa. Bên trong cây cải chứa nhiều vitamin như vitamin B1, B2, Betacaroten…Các hoạt chất này vừa tốt cho cơ thể vừa làm đẹp da, giúp nâng cao sức đề kháng chống chọi lại sự thay đổi của thời tiết.", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Rau mùi ngò", 2.30, R.drawable.a27, "100g", "Rau mùi thường được sử dụng để làm gia vị trong những bữa cơm gia đình Việt. Không chỉ là một loại rau thơm, rau mùi còn được coi như là một vị thuốc có tác dụng cực kì tốt cho sức khỏe của chúng ta. Rau mùi mang lại cho chúng ta một số công dụng như ngăn ngừa bệnh viêm khớp, có tác dụng long đờm và ngăn chặn nguy cơ mắc bệnh tiểu đường.", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Quả quất tươi", 4.10, R.drawable.a28, "200g", "Quả quất hay tắc  vừa có thể ăn tươi, làm nước giải khát, gia vị, vắt nước làm nước chấm hay ăn với bún, phở, làm mứt, sirô... vừa có tác dụng chữa bệnh, giải chất độc của rượu, chống say rượu, trừ mùi hôi. ", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Rau Răm", 2.30, R.drawable.a29, "100g", "Rau răm có hương thơm đặc biệt, vị cay tính ấm, có tinh dầu, là một loại gia vị được sử dụng phổ biến trong việc chế biến thức ăn như: Cháo hải sản, cháo trứng vịt lộn, trứng vịt lộn, gỏi gà, gỏi vịt,... ", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(2,"Nấm kim châm", 1.80, R.drawable.a30, "100g", "Nấm kim châm là loại nấm có màu trắng, thon dài thân nhọn như hình cây kim. Đây là nguyên liệu để chế biến rất nhiều món ăn ngon như: canh nấm, bò cuộn nấm kim châm, nấm kim châm xào. Ngoài ra, nấm kim châm rất hữu ích cho người già, người bị huyết áp cao. Loại nấm này chứa một số chất có tác dụng chống ung thư rất hiệu quả. Nấm kim châm chứa nhiều lysine rất cần cho quá trình sinh trưởng, cải thiện chiều cao và trí tuệ trẻ em, hạ mỡ máu, phòng chống bệnh lý viêm loét đường tiêu hóa và bệnh gan mật.", "Achau24", "Trung Quốc"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Mắm tôm Hậu Lộc", 2.90, R.drawable.a31, "350g", "Mắm Tôm Hậu Lộc có hương vị và mùi thơm đặc trưng, vị ngọt đằm, có màu sim chín, sền sệt, mịn, không còn lẫn muối hạt. ", "Hau Loc", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Gạo Jasmin 18kg Trung An", 25.80, R.drawable.a32, "18kg", "Gạo Jasmin Trung An có hạt gạo trong, dẻo mềm, không bạc bụng giúp cơm mềm, thơm nhẹ, dẻo ngon với giá thành tốt, phù hợp cho mọi gia đình.", "Trung An", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Gạo nếp cái hoa vàng 1kg", 2.75, R.drawable.a33, "1kg", "Nếp cái hoa vàng, có khi còn gọi là nếp ả hay nếp hoa vàng, là giống lúa nếp truyền thống nổi tiếng tại các tỉnh đồng bằng và trung du Bắc Bộ, Việt Nam, có hạt gạo tròn, dẻo, thơm đặc biệt nên thường dùng đồ xôi, làm cốm, làm các loại bánh có sử dụng gạo nếp, làm tương hoặc ủ rượu", "Achau24", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Dầu hào Healthy Boy", 2.50, R.drawable.a34, "300ml", "Dầu hào đậm đặc nguyên chất Healthy Boy được cô đặc từ hào nguyên chất kết hợp hoàn hảo cùng các gia vị khác. Sản phẩm là gia vị cho mọi món xào ngon của gia đình bạn. Dầu hào Healthy Boy mang vị ngọt của đạm, hương thơm nhẹ của hào biển. Đặc biệt, độ sệt vừa phải không đặc dính, màu nâu vàng sáng, giúp món ăn gia đình bạn thơm ngon, hấp dẫn hơn.", "Healthy Boy", "Thái Lan"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Ngũ Vị Hương ", 3.99, R.drawable.a35, "100g", "Ngũ vị hương là một loại gia vị tiện lợi dùng trong ẩm thực của người Trung Hoa hay Việt Nam, đặc biệt hay dùng trong ẩm thực của người Quảng Đông. Nó bao gồm năm loại vị cơ bản trong ẩm thực là: mặn, ngọt, chua, cay, đắng.", "VIANCO", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Nước mắm chin-su ", 3.90, R.drawable.a36, "500ml", "Nước mắm Chinsu thơm ngon, đậm đà, chất lượng đảo bảo, thích hợp làm nước chấm hay gia vị nấu ăn.", "Chin-su", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Nước mắm Việt Hương", 7.90, R.drawable.a37, "700ml", "Việt Hương là thương hiệu nước mắm uy tín lâu đời chuyên sản xuất các loại nước mắm truyền thống chất lượng cao. Nước mắm Việt Hương có hương vị thơm ngon, đậm đà đảm bảo an toàn sức khoẻ, không sử dụng các chất tạo màu, tạo mùi để cho ra mùi vị tự nhiên nhất.", "Viet Huong", "Việt Nam"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Nước mắm mực ", 1.89, R.drawable.a38, "700ml", "Nước mắm  mực có mùi đặc trưng, vị mặn vừa phải và có màu cánh gián nâu đỏ dùng làm gia vị chấm hoặc chế biến các món ăn hàng ngày.", "Squid Brand", "Thái Lan"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Gia vị lẩu thái Tom Yum ", 2.10, R.drawable.a39, "227g", "Thành phần của Gia vị nấu Lẩu Thái Tom Yum gồm: sả, giềng, dầu đậu nành, ớt tươi, đường, nước, lá chanh, hành tây , muối. Khi dùng bỏ 2 muổng gia vị với 3 ly nước sôi sau đó có thể bỏ phần mắm tôm, thủy hải sản và rau củ quả tùy thích", "Achau24", "Thái Lan"));
                                sInstance.sanPhamDao().insertSanPham(new SanPhamEntry(3,"Tương ớt Con Gà", 2.50, R.drawable.a40, "266ml", "Hương vị đặc trưng của Tương Ớt Con Gà Sriracha đã tạo nên một thương hiệu hàng đầu được tin dùng trên toàn thế giới.", "Sriracha", "Mỹ"));
                                Log.v("kiem tra insert sanpham", "da insert");

                            }
                        });
                    }
                })
                .build();

    }


    public abstract SanPhamDao sanPhamDao();

    public abstract GioHangDao gioHangDao();

    public abstract YeuThichDao yeuThichDao();
}
