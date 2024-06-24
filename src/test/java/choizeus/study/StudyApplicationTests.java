package choizeus.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional(readOnly = true)
@Rollback(value = false)
@ActiveProfiles("aws")
@TestPropertySource(locations = {"classpath:application.yml", "classpath:application-aws.yml"})
class StudyApplicationTests {


//
//	@Autowired
//	private ParentRepository parentRepository;
//
//	@Autowired
//	private ChildRepository childRepository;
//
////	@Test
////	@Transactional
////	public void addChild() {
////		Parent parent = new Parent("test1234", 25);
////		Child child = new Child("1234", parent);
////		Child child1 = new Child("5678", parent);
////		parent.addChild(child);
////		parent.addChild(child1);
////		parentRepository.save(parent);
////	}
//
//
////		@Test
////		@Transactional
////		public void findAllParent() {
////			List<Parent> parents = parentRepository.findByName("test1234");
//////			List<Parent> parents = parentRepository.findByName1("test1234");
////			for (Parent parent : parents) {
////				System.out.println("Parent Name: " + parent.getName());
////				for (Child child : parent.getChildList()) {
////					System.out.println("Child Name :" + child.getName());
////				}
////			}
////		}
//
//	@Test
//	@Transactional
//	public void findParent() {
//		PageRequest pageRequest = PageRequest.of(0, 3, Sort.by("name").descending());
//
//		List<Parent> parents = parentRepository.findByName1("test1234", pageRequest);
//
//		for(Parent parent : parents) {
//			System.out.println(parent.getName());
//		}
//
//	}
//
//
//	@Test
//	@Transactional
//	public void pagingTest() {
//		Parent parent = parentRepository.findById(33L).get();
//		Child child = childRepository.findChildById(7L);
//		ResponseDTO responseDTO = new ResponseDTO(
//				child.getName(),
//				parent.getName(),
//				parent.getAge());
//
//
//
//		System.out.println(responseDTO);
//
//	}
//









//	@Test
//	@Transactional
//	public void testUpdateName() {
//		Parent parent = new Parent("choizeus", 26);
//		parentRepository.save(parent);
////		parent.updateName("12345");
//		parent.updateAge(30);
//	}
//
//
//	@Test
//	public void testSaveParentWithChildren() {
//
//		Parent parent = new Parent("Parent", 25);
//
//		for (int i = 0; i < 3; i++) {
//			parentRepository.save(new Parent("Parent" + i, 25 + i));
//		}
//
//		Child child1 = new Child("Child 1", parent);
//		Child child2 = new Child("Child 2", parent);
//
//		parent.addChild(child1);
//		parent.addChild(child2);
//
//		parentRepository.save(parent);
//
//		Child child = childRepository.findChildById(1L);
//		System.out.println(child.getName());
//
//		Child child3 = childRepository.findChildById(2L);
//		System.out.println(child3.getName());
//
//		List<Parent> parent1 = parentRepository.findByName("Parent");
//		System.out.println(parent1.get(0));


//	}


}
