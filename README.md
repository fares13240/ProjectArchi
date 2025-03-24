---

# Projet Spring Boot – Application de Gestion des Examens

Ce projet est une application web développée avec Spring Boot, conçue pour faciliter la gestion des examens pour la Faculté d'Économie et de Gestion. L'application permet de gérer les utilisateurs (étudiants et enseignants), les cours, les examens, les quiz et les questions de manière centralisée et organisée.

---

## Fonctionnalités

- **Gestion des Utilisateurs**  
  - Création, lecture, mise à jour et suppression (CRUD) des utilisateurs.
  - Visualisation synthétique via DTO pour ne renvoyer que les informations essentielles.

- **Gestion des Cours**  
  - Création, lecture, mise à jour (complète ou partielle) et suppression des cours.
  - Affichage synthétique via DTO incluant :
    - Identifiant, titre, description, date de création.
    - Nombre d'examens liés et nombre d'étudiants inscrits.
    - Liste synthétique (prénom et nom) des étudiants inscrits.
  - Association d'un étudiant à un cours et désinscription.

- **Gestion des Examens**  
  - CRUD pour les examens.
  - Visualisation synthétique via DTO incluant le nombre de quiz, ainsi que l'identifiant et le titre du cours associé.

- **Gestion des Quiz**  
  - CRUD pour les quiz.
  - Chaque quiz est associé à un seul examen (relation ManyToOne).
  - Visualisation synthétique via DTO incluant le nombre de questions, l'identifiant et le titre de l'examen associé.

- **Gestion des Questions**  
  - CRUD pour les questions.
  - Visualisation synthétique via DTO incluant la liste de tous les quiz associés (résumés avec id et titre).


---

## Architecture et Organisation des Packages

Le projet est structuré en plusieurs packages pour séparer clairement les responsabilités :

- **`projectarchi.controller`**  
  Contient les classes contrôleurs REST qui exposent les endpoints de l’API (Users, Courses, Exams, Quizzes, Questions).

- **`projectarchi.dto`**  
  Contient les Data Transfer Objects (DTO) utilisés pour renvoyer des réponses synthétiques.  
  Exemples :  
  - `CourseDTO` – Informations synthétiques sur les cours.  
  - `ExamDTO` – Informations synthétiques sur les examens.  
  - `QuizDTO` – Informations synthétiques sur les quiz.  
  - `QuestionDTO` – Informations synthétiques sur les questions, incluant une liste de `QuizSummaryDTO`.  
  - `UserDTO` – Informations synthétiques sur les utilisateurs.  
  - `StudentSummaryDTO` – Résumé (prénom et nom) d’un étudiant.

- **`projectarchi.model`**  
  Contient les entités JPA qui représentent la structure de données persistante (Course, Exam, Quiz, Question, User).

- **`projectarchi.repository`**  
  Contient les interfaces Repository qui étendent Spring Data JPA pour accéder à la base de données (CourseRepository, ExamRepository, QuizRepository, QuestionRepository, UserRepository, etc.).

- **`projectarchi.service`**  
  Contient la logique métier et les services associés, y compris les méthodes de conversion d’entités en DTO (CourseService, ExamService, QuizService, QuestionService, UserService, etc.).

---

## Endpoints et Routes Disponibles

### Users
- **GET All Users (DTO)**  
  `http://localhost:8081/api/users/dto`
- **GET User by ID**  
  `http://localhost:8081/api/users/1`
- **POST Create User**  
  `http://localhost:8081/api/users`
- **PUT Update User**  
  `http://localhost:8081/api/users/1`
- **DELETE User**  
  `http://localhost:8081/api/users/1`

### Exams
- **GET All Exams (DTO)**  
  `http://localhost:8081/api/exams/dto`
- **GET Exam by ID**  
  `http://localhost:8081/api/exams/1`
- **POST Create Exam**  
  `http://localhost:8081/api/exams`
- **PUT Update Exam**  
  `http://localhost:8081/api/exams/1`
- **DELETE Exam**  
  `http://localhost:8081/api/exams/1`

### Questions
- **GET All Questions (DTO)**  
  `http://localhost:8081/api/questions/dto`
- **GET Question by ID**  
  `http://localhost:8081/api/questions/1`
- **POST Create Question**  
  `http://localhost:8081/api/questions`
- **PUT Update Question**  
  `http://localhost:8081/api/questions/1`
- **DELETE Question**  
  `http://localhost:8081/api/questions/1`

### Quizzes
- **GET All Quizzes (DTO)**  
  `http://localhost:8081/api/quizzes/dto`
- **GET Quiz by ID**  
  `http://localhost:8081/api/quizzes/1`
- **POST Create Quiz**  
  `http://localhost:8081/api/quizzes`
- **PUT Update Quiz**  
  `http://localhost:8081/api/quizzes/1`
- **DELETE Quiz**  
  `http://localhost:8081/api/quizzes/1`

### Courses
- **GET All Courses (DTO)**  
  `http://localhost:8081/api/courses/dto`
- **GET Course by ID (Entity)**  
  `http://localhost:8081/api/courses/1`
- **GET Course by ID (DTO)**  
  `http://localhost:8081/api/courses/1/dto`  
  *Réponse synthétique incluant id, title, description, creationDate, examCount, enrolledCount et liste des étudiants (prénom et nom)*
- **POST Create Course**  
  `http://localhost:8081/api/courses`  
  *Exemple de body JSON*:
  ```json
  {
    "title": "Cours d'économie",
    "description": "Description du cours",
    "creationDate": "2025-03-19T10:00:00",
    "exams": [],
    "students": []
  }
  ```
- **PUT Update Course**  
  `http://localhost:8081/api/courses/1`
- **PATCH Update Course Title**  
  `http://localhost:8081/api/courses/1/title`
- **PUT Update Course Exams**  
  `http://localhost:8081/api/courses/1/exams`
- **PUT Update Course Students**  
  `http://localhost:8081/api/courses/1/students`
- **GET Course Students Status**  
  `http://localhost:8081/api/courses/1/students/status`
- **DELETE Course**  
  `http://localhost:8081/api/courses/1`
- **POST Add Student to Course**  
  `http://localhost:8081/api/courses/{courseId}/students/{studentId}`

---

## Procédure de Test avec Postman

Pour tester l'ensemble des endpoints via Postman, suivez l'ordre ci-dessous :

1. **Importer la Collection Postman**  
   - Créez un fichier de collection (par exemple, `ProjetSpringBoot_API.postman_collection.json`) contenant toutes les routes listées ci-dessus.
   - Dans Postman, cliquez sur **Import**, puis sélectionnez le fichier ou copiez-collez le JSON de la collection.

2. **Test des Utilisateurs (Users)**  
   - **GET All Users** :  
     - URL : `http://localhost:8081/api/users`
     - Vérifiez que vous obtenez une liste d'utilisateurs synthétiques.
   - **POST Create User** :  
     - URL : `http://localhost:8081/api/users`
     - Envoyez un body JSON comme :
       ```json
       {
         "active": true,
         "email": "student1@example.com",
         "firstName": "Alice",
         "lastName": "Wonder",
         "password": "pass123",
         "role": "student",
         "username": "alicew"
       }
       ```
   - **GET User by ID**, **PUT Update User** et **DELETE User** : Testez ces endpoints en utilisant l'ID du user créé.

3. **Test des Examens (Exams)**  
   - **GET All Exams (DTO)** :  
     - URL : `http://localhost:8081/api/exams/dto`
   - **POST Create Exam** :  
     - URL : `http://localhost:8081/api/exams`
     - Exemple de body :
       ```json
       {
         "examTitle": "Examen d'économie",
         "course": { "id": 2 },
         "teacher": { "userId": 1 }
       }
       ```
   - **PUT Update Exam** et **DELETE Exam** : Testez en utilisant l'ID d'un examen existant.

4. **Test des Questions (Questions)**  
   - **GET All Questions (DTO)** :  
     - URL : `http://localhost:8081/api/questions/dto`
   - **POST Create Question** :  
     - URL : `http://localhost:8081/api/questions`
     - Exemple de body :
       ```json
       {
         "questionTitle": "Quelle est la principale source de revenu d'une entreprise ?",
         "category": "Finance",
         "difficultyLevel": "Moyen",
         "option1": "Option A",
         "option2": "Option B",
         "option3": "Option C",
         "option4": "Option D",
         "rightAnswer": 2,
         "exam": { "id": 1 }
       }
       ```
   - **PUT Update Question** et **DELETE Question** : Testez avec l'ID d'une question existante.

5. **Test des Quiz (Quizzes)**  
   - **GET All Quizzes (DTO)** :  
     - URL : `http://localhost:8081/api/quizzes/dto`
   - **POST Create Quiz** :  
     - URL : `http://localhost:8081/api/quizzes`
     - Exemple de body :
       ```json
       {
         "title": "Quiz d'économie",
         "exam": { "id": 1 },
         "questions": [ { "id": 1 }, { "id": 2 } ]
       }
       ```
   - **PUT Update Quiz** et **DELETE Quiz** : Testez avec l'ID d'un quiz existant.

6. **Test des Cours (Courses)**  
   - **GET All Courses (DTO)** :  
     - URL : `http://localhost:8081/api/courses/dto`
   - **GET Course by ID (DTO)** :  
     - URL : `http://localhost:8081/api/courses/1/dto`  
       *La réponse doit inclure le nombre d'examens, le nombre d'étudiants, et un listing synthétique (prénom et nom) des étudiants inscrits.*
   - **POST Create Course** :  
     - URL : `http://localhost:8081/api/courses`
     - Exemple de body :
       ```json
       {
         "title": "Cours d'économie",
         "description": "Description du cours",
         "creationDate": "2025-03-19T10:00:00",
         "exams": [],
         "students": []
       }
       ```
   - **PUT Update Course**, **PATCH Update Course Title**, **PUT Update Course Exams** et **PUT Update Course Students** : Testez ces endpoints en mettant à jour les informations d'un cours existant.
   - **GET Course Students Status** :  
     - URL : `http://localhost:8081/api/courses/1/students/status`
   - **DELETE Course** : Testez la suppression d'un cours.
   - **POST Add Student to Course** :  
     - URL : `http://localhost:8081/api/courses/{courseId}/students/{studentId}`  
       Remplacez `{courseId}` et `{studentId}` par des valeurs réelles.

7. **Test des Employés (Employees)**  
   - **GET All Employees** :  
     - URL : `http://localhost:8081/employees`
   - **GET Employee by LastName** :  
     - URL : `http://localhost:8081/employee/Doe`
   - **POST Create Employee** :  
     - URL : `http://localhost:8081/employees`
     - Exemple de body :
       ```json
       {
         "firstName": "Employee",
         "lastName": "Test",
         "dateOfBirth": "2000-01-01"
       }
       ```

---

## Configuration et Déploiement

- **Environnement de Développement**  
  - Java 17 (ou compatible avec Spring Boot 3.x)
  - Spring Boot (avec Spring Data JPA, Spring Web, etc.)
  - Base de données : H2 (pour les tests) ou PostgreSQL (pour production)

- **Configuration**  
  - Configurez vos paramètres de base de données dans `application.properties` ou `application.yml`.


- **Déploiement**  
  - Lancez votre application localement (par exemple, via Maven ou IntelliJ).
  - Assurez-vous que l’application est accessible sur `http://localhost:8081`.
  - L'application est aussi accessible sur `https://gestamu.ngrok.app/` où vous pouvez vous connecter pour executer les tests.

---

## Remarques et Perspectives

- **Utilisation des DTO** :  
  Les DTO permettent de renvoyer des réponses synthétiques sans la récursivité des entités. Cela améliore la clarté des réponses JSON et la sécurité en n'exposant pas d'informations internes non nécessaires.

- **Tests Postman** :  
  Suivez la procédure décrite ci-dessus pour tester l’ensemble des endpoints dans l’ordre pour chaque ressource.


- **Extensions Futures** :  
  - Utilisation d’outils de mapping automatique (ModelMapper, MapStruct) pour la conversion entité <-> DTO.
  - Amélioration de la gestion des relations et de la logique métier.
  - Ajout d'un ID et login pour gérer des vues Teacher/Students
  - Correction des problèmes et effets de bords sur les mises à jour (PATCH) de certaines routes.

---

Ce README fournit une vue complète du projet et détaille la procédure pour tester tous les endpoints via Postman dans l'ordre adéquat. N'hésitez pas à l'adapter en fonction de l'évolution de votre projet.
