 package in.sp.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sp.main.entity.Contest;

public interface ContestRepository  extends JpaRepository<Contest,Integer>
{

	public Contest findById(int id);

	

}
