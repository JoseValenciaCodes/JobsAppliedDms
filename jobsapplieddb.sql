-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 18, 2025 at 07:53 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jobsapplieddb`
--

-- --------------------------------------------------------

--
-- Table structure for table `applications`
--

CREATE TABLE `applications` (
  `id` bigint(20) NOT NULL,
  `applied_at` datetime(6) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `resume_link` varchar(255) NOT NULL,
  `shortlisted` bit(1) NOT NULL,
  `status` varchar(255) NOT NULL,
  `job_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applications`
--

INSERT INTO `applications` (`id`, `applied_at`, `created_at`, `resume_link`, `shortlisted`, `status`, `job_id`, `user_id`) VALUES
(4, '2025-03-24 23:30:00.000000', '2025-03-26 09:49:25.000000', 'https://resume.com/resume-link.pdf', b'0', 'rejected', 5, 1),
(5, '2025-03-28 07:35:00.000000', '2025-03-28 08:31:03.000000', 'https://resume.com/resume-link.pdf', b'0', 'pending', 6, 1),
(6, '2025-04-16 12:00:00.000000', '2025-04-18 07:45:58.000000', 'https://resume.com/resume-link.pdf', b'0', 'pending', 8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL,
  `avg_salary` double NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `demand` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `avg_salary`, `created_at`, `demand`, `description`, `name`) VALUES
(2, 65520.36, '2025-03-02 21:13:13.000000', 4, 'Industry sector related to selling products and promoting services', 'Sales'),
(7, 90000, '2025-03-28 07:52:21.000000', 5, 'Industry sector that has to do with Information Technology', 'IT'),
(8, 100000, '2025-03-28 07:53:00.000000', 5, 'Industry sector that has to do with curing people and keeping them healthy', 'Healthcare'),
(10, 75000, '2025-04-18 07:36:50.000000', 3, 'Industry sector that has to do with producing entertainment products for the population.', 'Entertainment'),
(11, 50000, '2025-04-18 07:37:42.000000', 2, 'Industry sector that has to do with producing industrial products from raw materials', 'Manufacturing'),
(12, 40000, '2025-04-18 07:40:28.000000', 3, 'Industry sector that has to do with transporting people/items from one place to another', 'Transportation'),
(13, 65000, '2025-04-18 07:47:14.000000', 3, 'Industry Sector that has to do with designing clothes', 'Fashion');

-- --------------------------------------------------------

--
-- Table structure for table `companies`
--

CREATE TABLE `companies` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `hiring_status` bit(1) NOT NULL,
  `location` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `priority_level` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `companies`
--

INSERT INTO `companies` (`id`, `created_at`, `description`, `hiring_status`, `location`, `name`, `priority_level`) VALUES
(5, '2025-03-11 10:00:59.000000', 'Canadian Bank', b'1', 'Nova Scotia, Canada', 'Scotiabank', 3),
(6, '2025-03-11 10:06:06.000000', 'Call Center', b'1', 'Santo Domingo, Dominican Republic', 'Alorica', 4),
(8, '2025-03-28 07:49:25.000000', 'Banco Popular Dominicano is a Dominican Republic bank providing retail and commercial banking services.', b'1', 'Santo Domingo, Dominican Republic', 'Banco Popular', 4),
(9, '2025-03-28 07:51:43.000000', 'The BHD Bank (also known as Banco Múltiple BHD, S.A[2]) is a private financial and mortgage bank in the Dominican Republic.', b'1', 'Santo Domingo, Dominican Republic', 'Banco BHD', 3),
(10, '2025-03-28 08:24:22.000000', 'Barcelo is the name and brand of a variety of rums from the Dominican Republic ', b'1', 'Puerto Plata, Dominican Republic', 'Barcelo Exports Imports', 3),
(11, '2025-03-28 08:25:32.000000', 'The Central Bank of the Dominican Republic regulates the country\'s monetary and banking system.', b'1', 'Santo Domingo, Dominican Republic', 'Central Bank of the Dominican Republic', 5),
(13, '2025-04-18 07:47:54.000000', 'Top fashion company', b'1', 'Santo Domingo, Dominican Republic', 'Gucci', 2);

-- --------------------------------------------------------

--
-- Table structure for table `jobs`
--

CREATE TABLE `jobs` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `salary` double NOT NULL,
  `title` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `company_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `jobs`
--

INSERT INTO `jobs` (`id`, `created_at`, `description`, `salary`, `title`, `type`, `category_id`, `company_id`) VALUES
(5, '2025-03-16 20:01:52.000000', 'Interact with customers to address inquiries, resolve issues, process orders, and ensure customer satisfaction', 67000, 'Customer Service Representative', 'full-time', 2, 6),
(6, '2025-03-28 08:26:36.000000', 'Design and maintain databases used to keep track of banking activity.', 75000, 'Bank Database Administrator', 'full-time', 7, 11),
(8, '2025-04-18 07:42:02.000000', 'Transport alcoholic products throughout the country by truck', 38000, 'Truck Driver', 'full-time', 12, 10),
(9, '2025-04-18 07:48:51.000000', 'Design attractive clothing people will wish to buy', 85000, 'Fashion Designer', 'full-time', 13, 13),
(10, '2025-04-18 07:48:51.000000', 'Design attractive clothing people will wish to buy', 85000, 'Fashion Designer', 'full-time', 13, 13);

-- --------------------------------------------------------

--
-- Table structure for table `spring_session`
--

CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `spring_session`
--

INSERT INTO `spring_session` (`PRIMARY_ID`, `SESSION_ID`, `CREATION_TIME`, `LAST_ACCESS_TIME`, `MAX_INACTIVE_INTERVAL`, `EXPIRY_TIME`, `PRINCIPAL_NAME`) VALUES
('b215e273-695d-4628-9823-dea035c55435', '51f0399b-1eab-4f95-977d-37a48f8eb688', 1744976140334, 1744976970621, 1800, 1744978770621, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `spring_session_attributes`
--

CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `spring_session_attributes`
--

INSERT INTO `spring_session_attributes` (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_BYTES`) VALUES
('b215e273-695d-4628-9823-dea035c55435', 'userId', 0xaced00057372000e6a6176612e6c616e672e4c6f6e673b8be490cc8f23df0200014a000576616c7565787200106a6176612e6c616e672e4e756d62657286ac951d0b94e08b02000078700000000000000001);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `is_employed` bit(1) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `age`, `created_at`, `email`, `first_name`, `is_employed`, `last_name`, `password`) VALUES
(1, 24, '2025-03-02 21:08:01.000000', 'jjbrach4@gmail.com', 'Jose', b'1', 'Brache', '$2a$10$txBh5AgXHOl2MDlR/yXRYOKoaezx4A5eIpWWuLpYn.bBumK6xTxhy'),
(3, 25, '2025-03-12 10:26:09.000000', 'pedro@martin.com', 'Pedro', b'0', 'Martin', '$2a$10$AqfzjfySheozKuFsNNFWT.hIA2zmnFRZPCW99KhnetIWCxBDk5q/G');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK65weib1lru9dkrbto5pv389vi` (`job_id`),
  ADD KEY `FKfsfqljedcla632u568jl5qf3w` (`user_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jobs`
--
ALTER TABLE `jobs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlunrv9ems34544ff26wyfa89v` (`category_id`),
  ADD KEY `FKrtmqcrktb6s7xq8djbs2a2war` (`company_id`);

--
-- Indexes for table `spring_session`
--
ALTER TABLE `spring_session`
  ADD PRIMARY KEY (`PRIMARY_ID`),
  ADD UNIQUE KEY `spring_session_ix1` (`SESSION_ID`),
  ADD KEY `spring_session_ix2` (`EXPIRY_TIME`),
  ADD KEY `spring_session_ix3` (`PRINCIPAL_NAME`);

--
-- Indexes for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applications`
--
ALTER TABLE `applications`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `companies`
--
ALTER TABLE `companies`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `jobs`
--
ALTER TABLE `jobs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `applications`
--
ALTER TABLE `applications`
  ADD CONSTRAINT `FK65weib1lru9dkrbto5pv389vi` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`),
  ADD CONSTRAINT `FKfsfqljedcla632u568jl5qf3w` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `jobs`
--
ALTER TABLE `jobs`
  ADD CONSTRAINT `FKlunrv9ems34544ff26wyfa89v` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `FKrtmqcrktb6s7xq8djbs2a2war` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`);

--
-- Constraints for table `spring_session_attributes`
--
ALTER TABLE `spring_session_attributes`
  ADD CONSTRAINT `spring_session_attributes_fk` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
