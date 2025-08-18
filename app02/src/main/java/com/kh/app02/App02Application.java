package com.kh.app02;

import com.kh.app02.board.entity.BoardEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App02Application {

	public static void main(String[] args) {
//		SpringApplication.run(App02Application.class, args);
		System.out.println("App02Application.main called~~!!");

		//공장 준비 - META-INF/persistence.xml에 공장 정보 넣기
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abc");
		
		//공장에서, 객체(엔티티 매니저) 꺼내기
		EntityManager em = emf.createEntityManager();

		//트랜잭션 객체 준비
		EntityTransaction tx = em.getTransaction();

		try{
			//트랜잭션 시작하기,,,
			tx.begin();

			//엔티티 다루기
			BoardEntity x1 = em.find(BoardEntity.class, 4L);
			BoardEntity x2 = em.find(BoardEntity.class, 4L);
			System.out.println(x1==x2);

			//엔티티 매니저야 객체 하나 줄께,,vo 던지기
			//1. 객체 생성
//			BoardEntity entity = new BoardEntity();
////			entity.setTitle("야옹이가");
////			entity.setContent("야옹야옹");
//			entity.setTitle("삭제될 객체 제목");
//			entity.setContent("삭제될 객체 제목");
//			//2. 영속화 (매니저한테 전달)
//			em.persist(entity);
//			em.flush(); //실제 쿼리 날리기 insert 쿼리실행
//
////			em.detach(entity); //엔티티 영속성 context(저장소)에서 분리
////			entity.setTitle("change ~~~"); //데이터 변경
////			em.merge(entity); //합친 후 다시 영속성 context(저장소)에 넣기
//
//			em.remove(entity); //1번에서 insert한 객체 삭제됨
//
//			//tx 커밋하기
//			System.out.println("===== 이제 커밋 할거임 ====== ");
//			tx.commit(); //여기서 flush가 자동 실행 되며 커밋으로 update 쿼리실행

		} catch (Exception e) {
			//문제 발생 시 rollback
			tx.rollback();
		}

		//(tx 종료에 flush 기능이 포함)
		//사용한 자원 반납
		em.close(); //매니저를 먼저 종료
		emf.close(); //factory 종료
	}

}
