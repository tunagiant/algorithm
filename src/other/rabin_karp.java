package other;

import java.util.ArrayList;
import java.util.List;

public class rabin_karp {

	public static void main(String[] args) {
		String txt = "BABABBAACACDADDAAVAABBAASAACACDBBAAC";
		String pat = "ACACD";
		List<Integer> list = new Solution().solve(txt, pat);
		for (Integer value : list) {
			System.out.print(value + "번째 발견");
			System.out.println();
		}
	}

}

class Solution {
	int mod = 13;
	
	List<Integer> solve(String txt, String pat) {
		double txtHash = 0, patHash = 0, power = 1;
		int txtLen = txt.length();
		int patLen = pat.length();
		
		// 패턴이 일치하는 위치를 저장할 리스트
		List<Integer> findedList = new ArrayList<>();

		for (int i = 0; i < txtLen - patLen; i++) {
			if (i == 0) {
				// 전체 문자열에 첫 파트의 hash 코드 구하기
				// 패턴 문자열 hash 코드 구하기
				for (int j = 0; j < patLen; j++) {
					txtHash = txtHash + txt.charAt(patLen - 1 - j) * power;
					patHash = patHash + pat.charAt(patLen - 1 - j) * power;
					if (j < patLen - 1) {
						power *= 2;
					}
											
				}
			} else {
				// 긴글 해시 값 = 2 * (첫파트 해시 값 - 가장 앞에 있는 문자) + 새롭게 들어온 문자
				txtHash = 2 * (txtHash - (txt.charAt(i - 1) * power))
						+ txt.charAt(patLen - 1 + i);
			}

			if (txtHash == patHash) {
				// 충돌확인
				boolean finded = true;
				for (int j = 0; j < patLen; j++) {
					if (txt.charAt(i + j) != pat.charAt(j)) {
						finded = false;
						break;
					}
				}

				if (finded) {
					findedList.add(i + 1);
				}
			}
		}

		return findedList;
	}
}
