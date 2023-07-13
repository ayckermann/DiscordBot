-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 12, 2023 at 09:33 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `discordbot`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL,
  `adminname` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`idAdmin`, `adminname`, `password`) VALUES
(1, 'admin', 'asd');

-- --------------------------------------------------------

--
-- Table structure for table `broadcast`
--

CREATE TABLE `broadcast` (
  `idBroadcast` int(11) NOT NULL,
  `messageBroadcast` varchar(255) NOT NULL,
  `sentTo` varchar(50) NOT NULL,
  `dateSent` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `broadcast`
--

INSERT INTO `broadcast` (`idBroadcast`, `messageBroadcast`, `sentTo`, `dateSent`) VALUES
(1, 'Good Afternoon @everyone', 'TO GUILD ayckermann\'s server', '28/06/2023 16:09'),
(2, 'Good Afternoon @everyone', 'TO ayckermann\'s server\'S MEMBER', '28/06/2023 16:11'),
(3, 'Good Afternoon ', 'TO GUILDS IN DATABASE', '28/06/2023 16:13'),
(4, 'halo', 'TO ayckermann\'s serverGUILD MEMBER', '29/06/2023 12:58'),
(5, 'HI', 'TO USERS IN DATABASE', '29/06/2023 20:47'),
(6, 'hi kawand', 'TO USERS IN DATABASE', '03/07/2023 17:05'),
(7, 'Hi', 'TO USERS IN DATABASE', '04/07/2023 11:04'),
(8, 'Hi', 'TO Aya Bot ServerGUILD MEMBER', '07/07/2023 11:59'),
(9, 'This is broadcast :)', 'TO USERS IN DATABASE', '07/07/2023 12:14');

-- --------------------------------------------------------

--
-- Table structure for table `guild`
--

CREATE TABLE `guild` (
  `guildId` varchar(20) NOT NULL,
  `guildName` varchar(32) NOT NULL,
  `defaultChannel` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `guild`
--

INSERT INTO `guild` (`guildId`, `guildName`, `defaultChannel`) VALUES
('1122174470141005874', 'Aya Bot Server', '1122174471189565536'),
('594614272907149314', 'RAETONGWAYAH', '896191920357920798');

-- --------------------------------------------------------

--
-- Table structure for table `log`
--

CREATE TABLE `log` (
  `id` int(11) NOT NULL,
  `userId` varchar(20) NOT NULL,
  `username` varchar(32) NOT NULL,
  `incoming` varchar(255) NOT NULL,
  `outgoing` text NOT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `log`
--

INSERT INTO `log` (`id`, `userId`, `username`, `incoming`, `outgoing`, `date`) VALUES
(1, '489755518941003776', 'ayckermann', 'hi', 'Halo?', '2023-07-03 13:56:59'),
(2, '489755518941003776', 'ayckermann', '/help', '**WELCOME TO AYA BOT**\r\nA fun bot made by Aya.\r\n\r\n**List of commands**\r\n/joke - Generate jokes that contain words as you like.\r\n/meme - Genereate meme (programming meme).\r\n/gpt - Type anything and ChatGPT will response.\r\n/purge - Purge messages.\r\n/help - This is /help.\r\n\r\n**Add me to your guild**\r\nhttps://bit.ly/AyaBot\r\n', '2023-07-03 16:53:47'),
(3, '489755518941003776', 'ayckermann', '/meme', 'https://sgp1.vultrobjects.com/kaushal-meme-api/meme_api_prod/memes/411.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=31MV23N3G46Q2UG2RT1V%2F20230703%2Fsgp1%2Fs3%2Faws4_request&X-Amz-Date=20230703T095428Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Signature=31f17b17e9760e88098a122e5ab61ad4cfd9515872fede8d922d2f2ca4279a15', '2023-07-03 16:54:27'),
(4, '489755518941003776', 'ayckermann', '/joke ', 'Hey baby I wish your name was asynchronous...\n... so you\'d give me a callback.', '2023-07-03 16:55:49'),
(5, '489755518941003776', 'ayckermann', '/gpt how to add log in svelte', 'To add a log-in functionality in a Svelte application, you can follow these general steps:\n\n1. Set up a login form component: Create a new component, for example, `LoginForm.svelte`, and define the HTML structure and inputs for the login form. You can use the `<form>` tag along with `<input>` fields for username and password.\n\n2. Create data bindings: Use two-way data binding to bind the input fields in the form to variables in your component\'s script. For example, you can use the `bind:value` directive to bind the input values to variables like `username` and `password`.\n\n```svelte\n<script>\n  let username = \"\";\n  let password = \"\";\n</script>\n\n<input type=\"text\" bind:value=\"{username}\" />\n<input type=\"password\" bind:value=\"{password}\" />\n```\n\n3. Handle form submissions: Add an `on:submit` event handler to the `<form>` tag to listen for form submissions. In this event handler, you can implement your login logic. For example, make an HTTP request to your server with the provided credentials and handle the response accordingly.\n\n```svelte\n<form on:submit=\"{handleLogin}\">\n  <!-- Input fields... -->\n  <button type=\"submit\">Log In</button>\n</form>\n\n<script>\n  async function handleLogin(event) {\n    event.preventDefault();\n    // Implement login logic using the username and password variables\n    \n    // Example:\n    const response = await fetch(\"/api/login\", {\n      method: \"POST\",\n      body: JSON.stringify({ username, password })\n    });\n\n    if (response.ok) {\n      // Successful login\n      // Redirect or update app state as needed\n    } else {\n      // Failed login\n      // Display error messages or update app state as needed\n    }\n  }\n</script>\n```\n\n4. Handle success/failure scenarios: Based on the response from your server, you can handle success and failure scenarios. For successful logins, you can redirect the user or update the application state. For failed logins, you can display error messages or update the application state to show an error notification.\n\nThese steps demonstrate a basic implementation of a login functionality in a Svelte application. However, keep in mind that handling user authentication and security is a complex topic that requires careful consideration of best practices and security measures.', '2023-07-03 16:58:05'),
(6, '576051207588806661', 'Samuelll_', '/help', '**WELCOME TO AYA BOT**\r\nA fun bot made by Aya.\r\n\r\n**List of commands**\r\n/joke - Generate jokes that contain words as you like.\r\n/meme - Genereate meme (programming meme).\r\n/gpt - Type anything and ChatGPT will response.\r\n/purge - Purge messages.\r\n/help - This is /help.\r\n\r\n**Add me to your guild**\r\nhttps://bit.ly/AyaBot\r\n', '2023-07-03 16:59:32'),
(7, '576051207588806661', 'Samuelll_', '/help', '**WELCOME TO AYA BOT**\r\nA fun bot made by Aya.\r\n\r\n**List of commands**\r\n/joke - Generate jokes that contain words as you like.\r\n/meme - Genereate meme (programming meme).\r\n/gpt - Type anything and ChatGPT will response.\r\n/purge - Purge messages.\r\n/help - This is /help.\r\n\r\n**Add me to your guild**\r\nhttps://bit.ly/AyaBot\r\n', '2023-07-03 17:00:02'),
(8, '576051207588806661', 'Samuelll_', '/joke ', 'What do you call a pile of kittens?\nA meowntain.', '2023-07-03 17:00:17'),
(9, '1029646118558121995', 'roynaldi', '/gpt tunjukan saya kode website keren', 'Tentu! Berikut adalah contoh kode untuk membuat sebuah website sederhana yang keren dengan menggunakan HTML, CSS, dan JavaScript:\n\nHTML:\n```html\n<!DOCTYPE html>\n<html>\n<head>\n	<title>Website Keren</title>\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n	<script src=\"script.js\"></script>\n</head>\n<body>\n	<header>\n		<h1>Selamat Datang di Website Keren</h1>\n	</header>\n\n	<nav>\n		<ul>\n			<li><a href=\"#\">Beranda</a></li>\n			<li><a href=\"#\">Tentang</a></li>\n			<li><a href=\"#\">Kontak</a></li>\n		</ul>\n	</nav>\n\n	<main>\n		<h2>Tentang Kami</h2>\n		<p>Website ini dibuat dengan tujuan untuk memberikan informasi dan inspirasi kepada pengunjungnya. Kami update konten secara rutin agar tetap up-to-date.</p>\n	</main>\n\n	<footer>\n		<p>Hak Cipta &copy; 2021 Website Keren</p>\n	</footer>\n</body>\n</html>\n```\n\nCSS (style.css):\n```css\nbody {\n    font-family: Arial, sans-serif;\n    margin: 0;\n    padding: 0;\n}\n\nheader {\n    background-color: #333;\n    color: #fff;\n    padding: 20px;\n    text-align: center;\n}\n\nnav ul {\n    list-style-type: none;\n    margin: 0;\n    padding: 0;\n    background-color: #f2f2f2;\n    text-align: center;\n}\n\nnav li {\n    display: inline-block;\n    margin: 10px;\n}\n\nnav a {\n    text-decoration: none;\n    color: #333;\n    padding: 5px 10px;\n    border: 1px solid #333;\n    border-radius: 5px;\n}\n\nmain {\n    width: 80%;\n    margin: 20px auto;\n}\n\nfooter {\n    background-color: #333;\n    color: #fff;\n    padding: 10px;\n    text-align: center;\n}\n```\n\nJavaScript (script.js):\n```javascript\n// Tidak ada kode JavaScript yang diperlukan dalam contoh website ini.\n```\n\nAnda dapat menyimpan setiap bagian kode di atas dalam sebuah file dengan ekstensi yang sesuai: `index.html`, `style.css`, dan `script.js`. Pastikan untuk menyimpannya di dalam satu folder yang sama. Setelah itu, Anda dapat membuka file `index.html` menggunakan browser untuk melihat tampilan dari website keren ini.', '2023-07-03 17:34:58'),
(10, '489755518941003776', 'ayckermann', 'hi', 'Halo?', '2023-07-03 19:50:32'),
(11, '489755518941003776', 'ayckermann', '/gpt how to connect firebase in svelte', 'To connect Firebase in Svelte, you can follow these steps:\n\nStep 1: Install Firebase package\n- Open your terminal and navigate to your Svelte project directory\n- Run the following command to install the Firebase package: `npm install firebase`\n\nStep 2: Firebase setup\n- Create a new Firebase project by going to the Firebase console (https://console.firebase.google.com) and clicking on \"Add project\".\n- Follow the steps to set up your project and enable Firebase services (such as Firestore, Authentication, etc.) as per your requirements.\n\nStep 3: Initialize Firebase in your Svelte app\n- Create a new JavaScript file (e.g., `firebase.js`) in your Svelte project directory.\n- Import the Firebase package: `import firebase from \'firebase/app\'`\n- Import the Firebase services you want to use (e.g., Firestore, Authentication): `import \'firebase/firestore\'` for Firestore, `import \'firebase/auth\'` for Authentication.\n- Set up the Firebase configuration by calling `firebase.initializeApp()` and passing in your Firebase project\'s configuration. You can find this configuration in your Firebase project settings.\n  \n  Here\'s an example of how the `firebase.js` file might look:\n\n  ```javascript\n  import firebase from \'firebase/app\';\n  import \'firebase/firestore\';\n  import \'firebase/auth\';\n\n  const firebaseConfig = {\n    // Your Firebase project configuration goes here\n  };\n\n  firebase.initializeApp(firebaseConfig);\n\n  export const db = firebase.firestore();\n  export const auth = firebase.auth();\n  ```\n\nStep 4: Use Firebase services in your Svelte components\n- Import the Firebase module in your Svelte components where you want to use Firebase services.\n- You can now use `db` to access Firestore and `auth` to access Authentication in your component logic.\n\nHere\'s an example of a Svelte component that uses Firebase Firestore to fetch data:\n\n```svelte\n<script>\n  import { onMount } from \'svelte\';\n  import { db } from \'../firebase.js\';\n\n  let todoList = [];\n\n  onMount(() => {\n    // Fetch data from Firestore collection\n    db.collection(\'todos\').get().then((querySnapshot) => {\n      querySnapshot.forEach((doc) => {\n        todoList.push(doc.data());\n      });\n    });\n  });\n</script>\n\n<ul>\n  {#each todoList as todo}\n    <li>{todo.title}</li>\n  {/each}\n</ul>\n```\n\nRemember to replace `\'../firebase.js\'` with the correct file path to your `firebase.js` file.\n\nThat\'s it! You\'ve successfully connected Firebase in your Svelte app.', '2023-07-03 19:51:21'),
(12, '489755518941003776', 'ayckermann', 'a', 'hai', '2023-07-04 11:02:18'),
(13, '489755518941003776', 'ayckermann', 'a', 'hai', '2023-07-04 11:02:18'),
(14, '489755518941003776', 'ayckermann', 'hi', 'Halo?', '2023-07-04 11:02:41'),
(15, '489755518941003776', 'ayckermann', 'hi', 'Halo?', '2023-07-04 11:02:41'),
(16, '489755518941003776', 'ayckermann', '/meme', 'https://sgp1.vultrobjects.com/kaushal-meme-api/meme_api_prod/memes/583.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=31MV23N3G46Q2UG2RT1V%2F20230704%2Fsgp1%2Fs3%2Faws4_request&X-Amz-Date=20230704T040653Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Signature=ca20f5267948679c830aca2f20ab35e8b3f1d65f00a3e6ee4f5351c4359e579c', '2023-07-04 11:06:53'),
(17, '489755518941003776', 'ayckermann', '/meme', 'https://sgp1.vultrobjects.com/kaushal-meme-api/meme_api_prod/memes/460.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=31MV23N3G46Q2UG2RT1V%2F20230704%2Fsgp1%2Fs3%2Faws4_request&X-Amz-Date=20230704T040653Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Signature=3e2ed765cc5272496bf0f19f96b130b6cb33419fe25a1fbc6cbe9108c72aba7d', '2023-07-04 11:06:53'),
(18, '489755518941003776', 'ayckermann', '/gpt print hallo world in java', 'To print \"Hello World\" in Java, you can use the following code:\n\n```java\npublic class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n    }\n}\n```\n\nSimply save this code in a file with a `.java` extension, such as `HelloWorld.java`. Then, compile and run the code to see the output \"Hello World\".', '2023-07-04 11:07:13'),
(19, '489755518941003776', 'ayckermann', '/gpt print hallo world in java', 'To print \"hello world\" in Java, you can use the following code:\n\n```java\npublic class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello, world!\");\n    }\n}\n```\n\nSave this code in a file named `HelloWorld.java`, then compile and run the program to see the output.', '2023-07-04 11:07:14'),
(20, '489755518941003776', 'ayckermann', 'hi', 'Halo?', '2023-07-05 21:15:41'),
(21, '489755518941003776', 'ayckermann', 'kamu bot?', 'Sorry I can\'t answer that message', '2023-07-05 21:16:26'),
(22, '489755518941003776', 'ayckermann', 'you good?', 'Sorry I can\'t answer that message', '2023-07-05 21:17:14'),
(23, '489755518941003776', 'ayckermann', '/hi', 'Sorry I can\'t answer that message', '2023-07-05 21:17:22'),
(24, '489755518941003776', 'ayckermann', '/help', '**WELCOME TO AYA BOT**\r\nA fun bot made by Aya.\r\n\r\n**List of commands**\r\n/joke - Generate jokes that contain words as you like.\r\n/meme - Genereate meme (programming meme).\r\n/gpt - Type anything and ChatGPT will response.\r\n/purge - Purge messages.\r\n/help - This is /help.\r\n\r\n**Add me to your guild**\r\nhttps://bit.ly/AyaBot\r\n', '2023-07-05 21:39:10'),
(25, '489755518941003776', 'ayckermann', '/joke blue', 'Joke tidak ditemukan', '2023-07-05 21:40:24'),
(26, '489755518941003776', 'ayckermann', '/joke knock', 'Joke tidak ditemukan', '2023-07-05 21:56:16'),
(27, '489755518941003776', 'ayckermann', '/joke knock', 'Joke tidak ditemukan', '2023-07-05 21:58:02'),
(28, '489755518941003776', 'ayckermann', '/gpt what is bard?', 'A bard is traditionally a poet, singer, or storyteller who often performs to entertain an audience. Bards have played an important role in different cultures throughout history, preserving and transmitting oral traditions, legends, and historical events through their performances. In some fantasy literature and role-playing games, bards are portrayed as versatile characters with skills in music, magic, and persuasion, often acting as support or charismatic party members.', '2023-07-05 22:01:25'),
(29, '489755518941003776', 'ayckermann', '/gpt I mean bard AI', 'Ah, I see! You\'re referring to a Bard AI, which would be an AI designed to generate or assist with creative content related to music, poetry, or storytelling. Is there something specific you would like assistance with?', '2023-07-05 22:01:59'),
(30, '489755518941003776', 'ayckermann', '/gpt noo, google bard, do you know it?', 'I apologize, but I am not familiar with Google Bard. Is there something specific you were looking for assistance with? I\'m here to help in any way I can!', '2023-07-05 22:03:38'),
(31, '489755518941003776', 'ayckermann', '/tugas', 'Sorry I can\'t answer that message', '2023-07-05 22:07:18'),
(32, '489755518941003776', 'ayckermann', 'hi', 'Halo?', '2023-07-05 22:17:04'),
(33, '489755518941003776', 'ayckermann', '/gpt buatkan latar belakang untuk SISTEM BANGUN CHATBOT UNTUK DISCORD BERTEMA HIBURAN BEBRBASIS JAVA', 'Latar belakang:\n\nDalam era teknologi modern ini, penggunaan platform komunikasi seperti Discord semakin populer di kalangan pengguna internet. Discord* merupakan platform yang digunakan untuk berkomunikasi dengan teman-teman dan komunitas, baik melalui pesan teks, suara, maupun video. Salah satu fitur populer di dalam Discord adalah kemampuan untuk menambahkan bot, yang dapat memberikan pengalaman interaktif dan fungsionalitas tambahan.\n\nDalam konteks ini, sebuah sistem bangun chatbot untuk Discord dengan tema hiburan menjadi solusi yang menarik. Chatbot bertema hiburan ini dibangun menggunakan bahasa pemrograman Java, yang memiliki banyak keunggulan seperti kestabilan, portabilitas, dan fleksibilitas.\n\nTujuan dibangunnya sistem chatbot ini adalah untuk meningkatkan pengalaman pengguna di Discord dengan menyediakan fitur-fitur hiburan. Fitur-fitur yang dapat diimplementasikan melalui sistem ini antara lain:\n\n1. Fitur meme dan humor: Sistem chatbot ini dapat menyediakan berbagai macam meme, meme generator secara acak, atau melakukan kagum dan jawaban lucu saat diberi perintah khusus.\n\n2. Fitur permainan: Sistem chatbot ini dapat menyediakan berbagai macam permainan yang dapat dimainkan bersama teman-teman di Discord, seperti tebak-tebakan, permainan kata, atau trivia.\n\n3. Fitur musik dan suara: Sistem chatbot ini dapat memutar musik atau efek suara tertentu yang diinginkan pengguna di saluran suara Discord.\n\n4. Fitur informasi dan pengetahuan: Sistem chatbot ini dapat menjawab pertanyaan atau memberikan informasi umum seputar topik apapun yang diminta oleh pengguna melalui perintah chat.\n\n5. Fitur kerjasama dengan bot lain: Sistem chatbot ini dapat berinteraksi dengan bot lain yang ada di Discord, seperti melakukan tugas administratif, pengaturan server, atau koordinasi dalam permainan tertentu.\n\nDengan adanya sistem chatbot dengan tema hiburan ini, pengguna Discord dapat memiliki pengalaman yang lebih menarik, interaktif, dan menyenangkan ketika menggunakan platform tersebut. Selain itu, sistem ini juga dapat digunakan untuk meningkatkan pemahaman dan pengetahuan pengguna melalui informasi yang disediakan.', '2023-07-06 14:00:06'),
(34, '489755518941003776', 'ayckermann', '/meme', 'com.ayckermann.discordbot.Meme@57660de8', '2023-07-06 14:05:29'),
(35, '489755518941003776', 'ayckermann', '/joke ', 'Everyone says that Hitler really loved animals.\nThen why did he kill 6 million of them?', '2023-07-06 14:06:23'),
(36, '1126705240117346324', 'bottester1', 'hi', 'Halo?', '2023-07-07 12:08:33'),
(37, '1126705240117346324', 'bottester1', 'asdfgh', 'Sorry I can\'t answer that message', '2023-07-07 12:08:42'),
(38, '1126705240117346324', 'bottester1', '/joke ', 'Has COVID-19 forced you to wear glasses and a mask at the same time?\nIf so, you may be entitled to condensation.', '2023-07-07 12:09:09'),
(39, '1126705240117346324', 'bottester1', '/meme', 'com.ayckermann.discordbot.Meme@7752cc85', '2023-07-07 12:09:23'),
(40, '1126705240117346324', 'bottester1', '/gpt how to print hello world in java', 'To print \"Hello World\" in Java, you can use the following code:\n\n```java\npublic class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n    }\n}\n```\n\nSave the code inside a file named HelloWorld.java, compile the code using the Java Compiler, and then run the compiled file to see the output \"Hello World\".', '2023-07-07 12:10:00'),
(41, '489755518941003776', 'ayckermann', '/joke ', 'Why are modern programming languages so materialistic?\nBecause they are object-oriented.', '2023-07-10 09:39:36'),
(42, '1125638592270700666', 'a71bsusanto', 'jggj', 'Sorry I can\'t answer that message', '2023-07-10 10:27:01'),
(43, '1125638592270700666', 'a71bsusanto', 'hoi', 'Sorry I can\'t answer that message', '2023-07-10 10:27:34');

-- --------------------------------------------------------

--
-- Table structure for table `msg_respond`
--

CREATE TABLE `msg_respond` (
  `idMessage` int(11) NOT NULL,
  `message` varchar(255) NOT NULL,
  `respond` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `msg_respond`
--

INSERT INTO `msg_respond` (`idMessage`, `message`, `respond`) VALUES
(1, 'Hi', 'Halo?'),
(2, 'Halo', 'Hiii'),
(4, 'a', 'hai');

-- --------------------------------------------------------

--
-- Table structure for table `slash_command`
--

CREATE TABLE `slash_command` (
  `idSlash` int(11) NOT NULL,
  `slashCommand` varchar(255) NOT NULL,
  `respondSlash` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `slash_command`
--

INSERT INTO `slash_command` (`idSlash`, `slashCommand`, `respondSlash`) VALUES
(1, '/gpt How to cook indomie', 'how to cook indomie? Here are the steps to cook Indomie noodles:\r\n\r\n1. Boil 2 cups of water in a small saucepan.\r\n2. Add the Indomie noodles and the seasoning packet to the boiling water.\r\n3. Stir the noodles occasionally for about 2-3 minutes until they are cooked.\r\n4. Once the noodles are cooked, remove the saucepan from heat and drain off the excess water.\r\n5. Add the seasoning oil and other toppings, such as vegetables or eggs, to the noodles and mix well.\r\n6. Serve hot and enjoy your delicious Indomie noodles.'),
(2, '/gpt how many model there are in decision tree', 'There are different types of decision tree algorithms, and the number of models varies depending on how the decision tree is constructed and trained. \n\nFor example, in a standard decision tree model, there is usually only one tree that represents the output decision. However, in some cases, you may see ensemble methods such as Random Forests or Gradient Boosting, where multiple decision trees are built and combined to improve accuracy. \n\nTherefore, the number of models in a decision tree depends on the algorithm and techniques used to construct and train the model.'),
(3, '/gpt how to print hellow world in mojo', 'Here\'s a way to print \"Hello World\" in Mojo:\n\n1. Open your favorite text editor and create a new file.\n2. Save the file with a .mojo extension (e.g., helloworld.mojo).\n3. Enter the following code:\n\n```\nfunc main() {\n    print(\"Hello World\")\n}\n```\n\n4. Save the file and run it using the Mojo interpreter.\n\nTo run the file using the Mojo interpreter, navigate to the directory where the file is saved in the command prompt or terminal and type: \n\n```\nmojo helloworld.mojo\n```\n\nThis should print \"Hello World\" to the console.'),
(4, '/gpt how to print hello world in mojo', 'Here\'s how you can print \"Hello World\" in Mojo:\n\n1. Open your preferred text editor.\n2. Create a new file and name it \"hello_world.mojo\".\n3. Type the following code in the file:\n```\nfunction main() {\n    print(\"Hello World\");\n}\n```\n4. Save the file.\n5. Open a command prompt or terminal window.\n6. Navigate to the directory where you saved the \"hello_world.mojo\" file.\n7. Type the following command to run the Mojo program: `mojo hello_world.mojo`\n\nThe program should now print \"Hello World\" in the console.'),
(5, '/gpt bagaimana cara bernafas dan menelan air liur sebagai anjing', 'Untuk bernafas, anjing akan menggunakan hidung dan mulut mereka. Ketika mereka menghirup udara, udara akan masuk melalui hidung, melewati faring, dan ke paru-paru. Anjing juga menggunakan lidah dan rahang mereka untuk menelan air liur. Saat mereka mengunyah atau menarik napas yang panjang, sel-sel di bawah lidah mereka akan memompa air liur ke mulut mereka dan kemudian anjing akan menelan secara otomatis.'),
(6, '/gpt how to use code python print hello world', 'To print \"Hello, World\" in Python, you can use the following code:\n\n```python\nprint(\"Hello, World\")\n```\n\nSimply type or copy this code into a Python script or interpreter, and run it. The output will be:\n\n```\nHello, World\n```'),
(7, '/gpt siapakah Aya Bot', 'Saya adalah Aya Bot, asisten virtual yang hadir untuk membantu Anda dalam menyelesaikan tugas atau menjawab pertanyaan yang Anda miliki. Ada yang lain yang dapat saya bantu?'),
(8, '/gpt how to be a man', 'To be a man, there are some qualities and actions you can prioritize and work on developing. Here are some suggestions:\r\n\r\n1. Take responsibility: Act with accountability and face up to the consequences of your actions. This involves owning up to your mistakes and learning from them.\r\n\r\n2. Be respectful: Treat others with kindness, empathy, and respect. Show respect for yourself as well. Practice good manners and consider the feelings and perspectives of others.\r\n\r\n3. Communicate effectively: Work on your communication skills by actively listening to others, expressing yourself clearly and honestly, and being open to different viewpoints. Effective communication helps build strong relationships.\r\n\r\n4. Show integrity: Act with honesty and strong moral principles. This means doing what is right, even when no one is watching. Uphold your values and demonstrate consistency in your words and actions.\r\n\r\n5. Develop resilience: Cultivate mental and emotional strength by learning to bounce back from setbacks and facing challenges with a positive attitude. Develop coping mechanisms to deal with stress effectively.\r\n\r\n6. Constantly learn and grow: Seek knowledge and personal growth. Embrace new experiences and opportunities for self-improvement. Challenge yourself to step out of your comfort zone and acquire new skills throughout your life.\r\n\r\n7. Be financially responsible: Manage your finances wisely, save for the future, and live within your means. Develop good budgeting habits and make informed decisions about money.\r\n\r\n8. Prioritize self-care: Take care of your physical, mental, and emotional well-being. Get enough sleep, exercise regularly, eat a balanced diet, and manage stress effectively. Seek support when needed and practice good self-care habits.\r\n\r\nRemember, being a man is not defined by stereotypes or societal expectations but by being true to yourself, living by your values, and respecting others.'),
(9, '/gpt Learn JavaScript in a nutshell', 'JavaScript is a versatile programming language primarily used for developing web applications. Here\'s a quick overview of key concepts and features of JavaScript:\r\n\r\n1. Syntax: JavaScript syntax is similar to other programming languages like Java and C++. It uses semicolons to end statements and curly braces to define blocks of code.\r\n\r\n2. Variables and Data Types: In JavaScript, you can declare variables using the keyword `var`, `let`, or `const`. It supports various data types including numbers, strings, booleans, objects, arrays, and more.\r\n\r\n3. Operators: JavaScript supports arithmetic, comparison, logical, and assignment operators to perform various operations on data values.\r\n\r\n4. Functions: Functions are reusable blocks of code that perform a specific task. You can define functions using the `function` keyword or with arrow functions.\r\n\r\n5. Control Flow: JavaScript provides control flow statements such as `if/else`, `switch/case`, `for`, `while`, and `do/while` loops to control the execution flow of your code.\r\n\r\n6. Objects: JavaScript is an object-oriented language, and you can create objects using object literals or constructor functions. Objects are used for encapsulating data and behavior.\r\n\r\n7. Arrays: Arrays are used to store multiple values in JavaScript. You can access array elements using indexes, manipulate them, add or remove elements, and more.\r\n\r\n8. DOM Manipulation: JavaScript can interact with the Document Object Model (DOM) to dynamically manipulate HTML elements, modify styles, change content, or respond to user events.\r\n\r\n9. Asynchronous Programming: JavaScript supports asynchronous programming using features like callbacks, promises, and async/await. This allows non-blocking execution of code and handling tasks such as API calls or file processing.\r\n\r\n10. Libraries and Frameworks: JavaScript has a vast ecosystem with numerous libraries and frameworks like React, Vue.js, Angular, Next.js, and Node.js. These help simplify and enhance the development process.\r\n\r\nRemember, this is just a nutshell overview. JavaScript is a deep and extensive language, so continued learning and practice are essential to master it fully.'),
(10, '/gpt how to print hello world in c++', 'To print \"Hello, World!\" in C++, you can use the `cout` function from the `iostream` header. Here is an example code:\n\n```cpp\n#include <iostream>\n\nint main() {\n    std::cout << \"Hello, World!\" << std::endl;\n    return 0;\n}\n```\n\nSave this code in a `.cpp` file, then compile and run it using a C++ compiler. You should see the output \"Hello, World!\" displayed in the console.'),
(11, '/gpt what happened to the ocean gate titan', 'I\'m sorry, but I couldn\'t find any specific information on an \"Ocean Gate Titan.\" It\'s possible that there may be some confusion or the information you\'re seeking is not widely known. Can you provide more details or clarify your question?'),
(12, '/help', '**WELCOME TO AYA BOT**\r\nA fun bot made by Aya.\r\n\r\n**List of commands**\r\n/joke - Generate jokes that contain words as you like.\r\n/meme - Genereate meme (programming meme).\r\n/gpt - Type anything and ChatGPT will response.\r\n/purge - Purge messages.\r\n/help - This is /help.\r\n\r\n**Add me to your guild**\r\nhttps://bit.ly/AyaBot\r\n'),
(13, '/gpt how to add log in svelte', 'To add a log-in functionality in a Svelte application, you can follow these general steps:\n\n1. Set up a login form component: Create a new component, for example, `LoginForm.svelte`, and define the HTML structure and inputs for the login form. You can use the `<form>` tag along with `<input>` fields for username and password.\n\n2. Create data bindings: Use two-way data binding to bind the input fields in the form to variables in your component\'s script. For example, you can use the `bind:value` directive to bind the input values to variables like `username` and `password`.\n\n```svelte\n<script>\n  let username = \"\";\n  let password = \"\";\n</script>\n\n<input type=\"text\" bind:value=\"{username}\" />\n<input type=\"password\" bind:value=\"{password}\" />\n```\n\n3. Handle form submissions: Add an `on:submit` event handler to the `<form>` tag to listen for form submissions. In this event handler, you can implement your login logic. For example, make an HTTP request to your server with the provided credentials and handle the response accordingly.\n\n```svelte\n<form on:submit=\"{handleLogin}\">\n  <!-- Input fields... -->\n  <button type=\"submit\">Log In</button>\n</form>\n\n<script>\n  async function handleLogin(event) {\n    event.preventDefault();\n    // Implement login logic using the username and password variables\n    \n    // Example:\n    const response = await fetch(\"/api/login\", {\n      method: \"POST\",\n      body: JSON.stringify({ username, password })\n    });\n\n    if (response.ok) {\n      // Successful login\n      // Redirect or update app state as needed\n    } else {\n      // Failed login\n      // Display error messages or update app state as needed\n    }\n  }\n</script>\n```\n\n4. Handle success/failure scenarios: Based on the response from your server, you can handle success and failure scenarios. For successful logins, you can redirect the user or update the application state. For failed logins, you can display error messages or update the application state to show an error notification.\n\nThese steps demonstrate a basic implementation of a login functionality in a Svelte application. However, keep in mind that handling user authentication and security is a complex topic that requires careful consideration of best practices and security measures.'),
(14, '/gpt tunjukan saya kode website keren', 'Tentu! Berikut adalah contoh kode untuk membuat sebuah website sederhana yang keren dengan menggunakan HTML, CSS, dan JavaScript:\n\nHTML:\n```html\n<!DOCTYPE html>\n<html>\n<head>\n	<title>Website Keren</title>\n	<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n	<script src=\"script.js\"></script>\n</head>\n<body>\n	<header>\n		<h1>Selamat Datang di Website Keren</h1>\n	</header>\n\n	<nav>\n		<ul>\n			<li><a href=\"#\">Beranda</a></li>\n			<li><a href=\"#\">Tentang</a></li>\n			<li><a href=\"#\">Kontak</a></li>\n		</ul>\n	</nav>\n\n	<main>\n		<h2>Tentang Kami</h2>\n		<p>Website ini dibuat dengan tujuan untuk memberikan informasi dan inspirasi kepada pengunjungnya. Kami update konten secara rutin agar tetap up-to-date.</p>\n	</main>\n\n	<footer>\n		<p>Hak Cipta &copy; 2021 Website Keren</p>\n	</footer>\n</body>\n</html>\n```\n\nCSS (style.css):\n```css\nbody {\n    font-family: Arial, sans-serif;\n    margin: 0;\n    padding: 0;\n}\n\nheader {\n    background-color: #333;\n    color: #fff;\n    padding: 20px;\n    text-align: center;\n}\n\nnav ul {\n    list-style-type: none;\n    margin: 0;\n    padding: 0;\n    background-color: #f2f2f2;\n    text-align: center;\n}\n\nnav li {\n    display: inline-block;\n    margin: 10px;\n}\n\nnav a {\n    text-decoration: none;\n    color: #333;\n    padding: 5px 10px;\n    border: 1px solid #333;\n    border-radius: 5px;\n}\n\nmain {\n    width: 80%;\n    margin: 20px auto;\n}\n\nfooter {\n    background-color: #333;\n    color: #fff;\n    padding: 10px;\n    text-align: center;\n}\n```\n\nJavaScript (script.js):\n```javascript\n// Tidak ada kode JavaScript yang diperlukan dalam contoh website ini.\n```\n\nAnda dapat menyimpan setiap bagian kode di atas dalam sebuah file dengan ekstensi yang sesuai: `index.html`, `style.css`, dan `script.js`. Pastikan untuk menyimpannya di dalam satu folder yang sama. Setelah itu, Anda dapat membuka file `index.html` menggunakan browser untuk melihat tampilan dari website keren ini.'),
(15, '/gpt how to connect firebase in svelte', 'To connect Firebase in Svelte, you can follow these steps:\n\nStep 1: Install Firebase package\n- Open your terminal and navigate to your Svelte project directory\n- Run the following command to install the Firebase package: `npm install firebase`\n\nStep 2: Firebase setup\n- Create a new Firebase project by going to the Firebase console (https://console.firebase.google.com) and clicking on \"Add project\".\n- Follow the steps to set up your project and enable Firebase services (such as Firestore, Authentication, etc.) as per your requirements.\n\nStep 3: Initialize Firebase in your Svelte app\n- Create a new JavaScript file (e.g., `firebase.js`) in your Svelte project directory.\n- Import the Firebase package: `import firebase from \'firebase/app\'`\n- Import the Firebase services you want to use (e.g., Firestore, Authentication): `import \'firebase/firestore\'` for Firestore, `import \'firebase/auth\'` for Authentication.\n- Set up the Firebase configuration by calling `firebase.initializeApp()` and passing in your Firebase project\'s configuration. You can find this configuration in your Firebase project settings.\n  \n  Here\'s an example of how the `firebase.js` file might look:\n\n  ```javascript\n  import firebase from \'firebase/app\';\n  import \'firebase/firestore\';\n  import \'firebase/auth\';\n\n  const firebaseConfig = {\n    // Your Firebase project configuration goes here\n  };\n\n  firebase.initializeApp(firebaseConfig);\n\n  export const db = firebase.firestore();\n  export const auth = firebase.auth();\n  ```\n\nStep 4: Use Firebase services in your Svelte components\n- Import the Firebase module in your Svelte components where you want to use Firebase services.\n- You can now use `db` to access Firestore and `auth` to access Authentication in your component logic.\n\nHere\'s an example of a Svelte component that uses Firebase Firestore to fetch data:\n\n```svelte\n<script>\n  import { onMount } from \'svelte\';\n  import { db } from \'../firebase.js\';\n\n  let todoList = [];\n\n  onMount(() => {\n    // Fetch data from Firestore collection\n    db.collection(\'todos\').get().then((querySnapshot) => {\n      querySnapshot.forEach((doc) => {\n        todoList.push(doc.data());\n      });\n    });\n  });\n</script>\n\n<ul>\n  {#each todoList as todo}\n    <li>{todo.title}</li>\n  {/each}\n</ul>\n```\n\nRemember to replace `\'../firebase.js\'` with the correct file path to your `firebase.js` file.\n\nThat\'s it! You\'ve successfully connected Firebase in your Svelte app.'),
(16, '/gpt print hallo world in java', 'To print \"Hello World\" in Java, you can use the following code:\n\n```java\npublic class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n    }\n}\n```\n\nSimply save this code in a file with a `.java` extension, such as `HelloWorld.java`. Then, compile and run the code to see the output \"Hello World\".'),
(18, '/gpt what is bard?', 'A bard is traditionally a poet, singer, or storyteller who often performs to entertain an audience. Bards have played an important role in different cultures throughout history, preserving and transmitting oral traditions, legends, and historical events through their performances. In some fantasy literature and role-playing games, bards are portrayed as versatile characters with skills in music, magic, and persuasion, often acting as support or charismatic party members.'),
(19, '/gpt I mean bard AI', 'Ah, I see! You\'re referring to a Bard AI, which would be an AI designed to generate or assist with creative content related to music, poetry, or storytelling. Is there something specific you would like assistance with?'),
(20, '/gpt noo, google bard, do you know it?', 'I apologize, but I am not familiar with Google Bard. Is there something specific you were looking for assistance with? I\'m here to help in any way I can!'),
(21, '/gpt buatkan latar belakang untuk SISTEM BANGUN CHATBOT UNTUK DISCORD BERTEMA HIBURAN BEBRBASIS JAVA', 'Latar belakang:\n\nDalam era teknologi modern ini, penggunaan platform komunikasi seperti Discord semakin populer di kalangan pengguna internet. Discord* merupakan platform yang digunakan untuk berkomunikasi dengan teman-teman dan komunitas, baik melalui pesan teks, suara, maupun video. Salah satu fitur populer di dalam Discord adalah kemampuan untuk menambahkan bot, yang dapat memberikan pengalaman interaktif dan fungsionalitas tambahan.\n\nDalam konteks ini, sebuah sistem bangun chatbot untuk Discord dengan tema hiburan menjadi solusi yang menarik. Chatbot bertema hiburan ini dibangun menggunakan bahasa pemrograman Java, yang memiliki banyak keunggulan seperti kestabilan, portabilitas, dan fleksibilitas.\n\nTujuan dibangunnya sistem chatbot ini adalah untuk meningkatkan pengalaman pengguna di Discord dengan menyediakan fitur-fitur hiburan. Fitur-fitur yang dapat diimplementasikan melalui sistem ini antara lain:\n\n1. Fitur meme dan humor: Sistem chatbot ini dapat menyediakan berbagai macam meme, meme generator secara acak, atau melakukan kagum dan jawaban lucu saat diberi perintah khusus.\n\n2. Fitur permainan: Sistem chatbot ini dapat menyediakan berbagai macam permainan yang dapat dimainkan bersama teman-teman di Discord, seperti tebak-tebakan, permainan kata, atau trivia.\n\n3. Fitur musik dan suara: Sistem chatbot ini dapat memutar musik atau efek suara tertentu yang diinginkan pengguna di saluran suara Discord.\n\n4. Fitur informasi dan pengetahuan: Sistem chatbot ini dapat menjawab pertanyaan atau memberikan informasi umum seputar topik apapun yang diminta oleh pengguna melalui perintah chat.\n\n5. Fitur kerjasama dengan bot lain: Sistem chatbot ini dapat berinteraksi dengan bot lain yang ada di Discord, seperti melakukan tugas administratif, pengaturan server, atau koordinasi dalam permainan tertentu.\n\nDengan adanya sistem chatbot dengan tema hiburan ini, pengguna Discord dapat memiliki pengalaman yang lebih menarik, interaktif, dan menyenangkan ketika menggunakan platform tersebut. Selain itu, sistem ini juga dapat digunakan untuk meningkatkan pemahaman dan pengetahuan pengguna melalui informasi yang disediakan.'),
(22, '/gpt how to print hello world in java', 'To print \"Hello World\" in Java, you can use the following code:\n\n```java\npublic class HelloWorld {\n    public static void main(String[] args) {\n        System.out.println(\"Hello World\");\n    }\n}\n```\n\nSave the code inside a file named HelloWorld.java, compile the code using the Java Compiler, and then run the compiled file to see the output \"Hello World\".');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` varchar(20) NOT NULL,
  `displayName` varchar(255) NOT NULL,
  `username` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `displayName`, `username`) VALUES
('1029646118558121995', 'roynaldi', 'roynaldi'),
('1125638592270700666', 'a71bsusanto', 'a71bsusanto'),
('1126705240117346324', 'Tester1', 'bottester1'),
('489755518941003776', 'Aya', 'ayckermann'),
('576051207588806661', 'Samuelll_', 'Samuelll_');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `broadcast`
--
ALTER TABLE `broadcast`
  ADD PRIMARY KEY (`idBroadcast`);

--
-- Indexes for table `guild`
--
ALTER TABLE `guild`
  ADD PRIMARY KEY (`guildId`);

--
-- Indexes for table `log`
--
ALTER TABLE `log`
  ADD PRIMARY KEY (`id`),
  ADD KEY `log_ibfk_1` (`userId`);

--
-- Indexes for table `msg_respond`
--
ALTER TABLE `msg_respond`
  ADD PRIMARY KEY (`idMessage`),
  ADD UNIQUE KEY `message` (`message`);

--
-- Indexes for table `slash_command`
--
ALTER TABLE `slash_command`
  ADD PRIMARY KEY (`idSlash`),
  ADD UNIQUE KEY `slashCommand` (`slashCommand`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `broadcast`
--
ALTER TABLE `broadcast`
  MODIFY `idBroadcast` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `log`
--
ALTER TABLE `log`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `msg_respond`
--
ALTER TABLE `msg_respond`
  MODIFY `idMessage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `slash_command`
--
ALTER TABLE `slash_command`
  MODIFY `idSlash` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `log`
--
ALTER TABLE `log`
  ADD CONSTRAINT `log_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
