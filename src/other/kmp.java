package other;
//https://bowbowbow.tistory.com/6
//https://devje8.tistory.com/24

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kmp {

	public static int result, pi[];
	public static String origin, pattern;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine();
		pattern = br.readLine();
		
		pi = new int[pattern.length()];
		getPi();
		KMP();
	}
	
	private static void getPi() {
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			// 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동. j가 0이면 더이상 물러날 곳 없음
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
				j = pi[j - 1];
			}
			// 맞는 경우
			if(pattern.charAt(i) == pattern.charAt(j)) {
				/*
				 * i길이 문자열의 공통 길이는 j의 위치 + 1(1. 일치하는 길이의 의미 2. 0~j까지는 일치하는거 확인됨.)
				 * 되돌아올 때 pi[i]의 의미는
				 * 1. 그 당시의 '접두사, 접미사 일치길이'
				 * 2. '0~j까지는 일치하는거 확인됐으니 j+1부터 검사해'
				 * */
				pi[i] = ++j;
			}
		}
	}
	
	private static void KMP() {
		int count = 0;
		int j = 0;
		for (int i = 0; i < origin.length(); i++) {
			// 맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
			while(j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			// 맞는 경우
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
//					result = 1;
//					break;
					j = 0;
					count++;
					continue;
				}
				//맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
				else
					++j;
			}
		}
		System.out.println(count);
	}
}