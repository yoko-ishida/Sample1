import java.util.*;

public class Sekigae_ishida {
	public static void main(String[] ainrgs) {

//生徒数を入力
		System.out.println("人数を入力してください");
		int member_num = new Scanner(System.in).nextInt();


		//配列を作成
		String[] class_member = new String[member_num];


//名前を入力
		System.out.println("名前を入力してください。");
		for (int i = 0; i < member_num; i++) {
			class_member[i] = new Scanner(System.in).nextLine();
		}

		int select_continue = 1;
		do {

//机の並びの列数を入力
			//一列の人数
			System.out.println("横に並ぶ人数は何人ですか。");
			int line_num = 6;
			line_num = new Scanner(System.in).nextInt();


//予約席の有無を入力
			System.out.println("\r\n予約席は何席ありますか。なし：0　あり：予約席数を入力");
			int num_reserved = new Scanner(System.in).nextInt();

//予約がある場合の処理その1
			//新しい実際の座席表をつくる
			String[] jissai_sheet = new String[member_num + num_reserved];


			//予約済みのところを入れる
			for (int i = 0; i < num_reserved; i++) {
				System.out.println("予約の席番号を入力してください");
				int no = new Scanner(System.in).nextInt();
				int indexNo = no - 1;
				jissai_sheet[indexNo] = "予約済み";
			}


//席替えスタート
			System.out.println("席替えをスタートしますか？");
			System.out.println("1：はい　2：いいえ");
			int select_start = new Scanner(System.in).nextInt();


			//生徒数の数の配列を作成し、　値にかぶらないように席ナンバー1-15を入れる
			//配列のインデックスnoとして使うときは-1してます

			int[] sheet = new int[member_num];

			//2重にならないように配列に値をいれます。
			//まず、一つ目の値を配列に代入、表示
			int value_01 = new Random().nextInt(member_num) + 1;
			sheet[0] = value_01;

			//予約がない場合
			if (num_reserved == 0) {
				System.out.println( "1列目");
				System.out.print( "【座席1】　" + class_member[sheet[0] - 1]);
			}

			//次に、配列に入っていない値を次の値に入れる。繰り返し。
			int value_02 = 0;
			boolean is_continue = true;
			int row = 2;

			for (int i = 1; i < member_num ; i++) {
				do {
					value_02 = new Random().nextInt(member_num) + 1;
					is_continue = false;

					for (int value : sheet) {
						if (value == value_02) {
							is_continue = true;
						}
					}
				} while (is_continue);

				sheet[i] = value_02;

//予約席がない場合
				if (num_reserved == 0) {

					//席順順に表示
					System.out.print( "【座席" + (i + 1) + "】　" +  class_member[sheet[i] - 1]);

					if ((i + 1) % line_num == 0) {
						System.out.println("");
						System.out.println( row + "列目");
						row++;
					}

				}


			}
			//余白
			System.out.println("");




//予約席がある場合の処理その2

//予約のところをぬいてあたらしい席次表に名前を入れる
			int i = 0;
			for (int j = 0; j < member_num + num_reserved; j++) {
				if (jissai_sheet[j] != "予約済み") {
					jissai_sheet[j] = class_member[sheet[i] - 1];
					i++;
				}
			}

//列数で改行するように表示する
			if (num_reserved > 0) {
				for (i = 0; i < jissai_sheet.length; i++) {
					System.out.print("【座席" + (i + 1) + "】　" +  jissai_sheet[i]);
					if ((i + 1) % line_num == 0) {
						System.out.println("");
					}
				}

			}
			System.out.println("");


			System.out.println("名前を入れ終わったところからもう一度やり直しますか？");
			System.out.println("1：はい　0：いいえ");
			select_continue = new Scanner(System.in).nextInt();
		} while (select_continue == 1);

	}

}











