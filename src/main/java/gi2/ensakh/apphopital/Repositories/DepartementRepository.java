package gi2.ensakh.apphopital.Repositories;

import gi2.ensakh.apphopital.Entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
    @Query("select dr.dep.num from Medecin dr where dr.cin = :cin")
    public int findIdDepByMedCin(@Param("cin") String cin);
    @Query("select d.nom_dep from Departement d ")
    List<String> findAllDept();

//Departement findByNom_dep(String nomDep);
    @Query("select d from Departement d where d.nom_dep = :nomDep")
    public Departement findByNom_dep(String nomDep);
   }
