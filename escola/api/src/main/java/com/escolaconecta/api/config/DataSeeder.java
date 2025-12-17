package com.escolaconecta.api.config;

import com.escolaconecta.api.model.Parent;
import com.escolaconecta.api.model.School;
import com.escolaconecta.api.model.Student;
import com.escolaconecta.api.model.Warning; // Importante
import com.escolaconecta.api.model.SchoolEvent;
import com.escolaconecta.api.repository.ParentRepository;
import com.escolaconecta.api.repository.SchoolRepository;
import com.escolaconecta.api.repository.StudentRepository;
import com.escolaconecta.api.repository.WarningRepository; // Importante
import com.escolaconecta.api.repository.SchoolEventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class DataSeeder implements CommandLineRunner {

    private final SchoolRepository schoolRepository;
    private final ParentRepository parentRepository;
    private final StudentRepository studentRepository;
    private final WarningRepository warningRepository; // Adicionado
    private final SchoolEventRepository schoolEventRepository;

    // Construtor com todos os Repositories
    public DataSeeder(SchoolRepository schoolRepository, 
                      ParentRepository parentRepository, 
                      StudentRepository studentRepository,
                      WarningRepository warningRepository, // Adicionado
                      SchoolEventRepository schoolEventRepository) {
        this.schoolRepository = schoolRepository;
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.warningRepository = warningRepository; // Adicionado
        this.schoolEventRepository = schoolEventRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Criar Escolas
        School escolaA = new School();
        escolaA.setName("Colégio B");
        escolaA.setAddress("Rua 1, 123");

        School escolaB = new School();
        escolaB.setName("Colégio A");
        escolaB.setAddress("Av. Paulista, 900");

        schoolRepository.saveAll(Arrays.asList(escolaA, escolaB));

        // 2. Criar o Pai
        Parent pai = new Parent();
        pai.setName("Carlos Silva");
        pai.setEmail("carlos@gmail.com");
        pai.setPassword("123456");

        parentRepository.save(pai);

        // 3. Criar Filhos (Vinculando Pai e Escola)
        
        // Filho 1 -> Na Escola A
        Student filho1 = new Student();
        filho1.setName("Neymar Jr");
        filho1.setRA("2023-001"); // Ajustado para bater com a Entity Student
        filho1.setParent(pai);   // Vincula ao Pai
        filho1.setSchool(escolaA); // Vincula à Escola A

        // Filho 2 -> Na Escola B
        Student filho2 = new Student();
        filho2.setName("L. Messi");
        filho2.setRA("2023-099"); // Ajustado
        filho2.setParent(pai);   // Vincula ao mesmo Pai
        filho2.setSchool(escolaB); // Vincula à Escola B

        studentRepository.saveAll(Arrays.asList(filho1, filho2));

        // 4. Criar Advertências (Para testar o botão de aviso)
        Warning adv1 = new Warning();
        adv1.setTitle("Uso de celular em sala");
        adv1.setDescription("O aluno foi visto jogando durante a explicação.");
        adv1.setDate(LocalDate.now());
        adv1.setStudent(filho1); // Advertência para o Joãozinho

        warningRepository.save(adv1);

        // 5. Criar Eventos (Para testar a Home da Escola)
        
        // Evento para a Escola A
        SchoolEvent eventoA = new SchoolEvent();
        eventoA.setTitle("Reunião de Pais e Mestres");
        eventoA.setDescription("Discussão sobre o encerramento do semestre.");
        eventoA.setDate(LocalDate.now().plusDays(5));
        eventoA.setType("REUNIAO");
        eventoA.setSchool(escolaA);

        // Evento para a Escola B
        SchoolEvent eventoB = new SchoolEvent();
        eventoB.setTitle("Festa da Primavera");
        eventoB.setDescription("Venham fantasiados de flores!");
        eventoB.setDate(LocalDate.now().plusDays(10));
        eventoB.setType("FESTA");
        eventoB.setSchool(escolaB);

        schoolEventRepository.saveAll(Arrays.asList(eventoA, eventoB));

        System.out.println("--- DADOS COMPLETOS: ALUNOS, ADVERTÊNCIAS E EVENTOS CARREGADOS ---");
    }
}