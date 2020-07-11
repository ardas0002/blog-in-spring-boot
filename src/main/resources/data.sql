INSERT INTO role (description, role) VALUES ('Default user role', 'USER');
INSERT INTO role (description, role) VALUES ('Admin user role', 'ADMIN');

INSERT INTO user (email, first_name, last_name, login, password) VALUES ('ardas@gmail.com', 'Adrian', 'Trocki', 'Ardas', 'secret');
INSERT INTO user (email, first_name, last_name, login, password) VALUES ('jwt231@gmail.com', 'Mateusz', 'Nowak', 'Matt2020', 'secret');

INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);

INSERT INTO post (post_author, post_title, post_summary, post_content) VALUES (1, 'Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fermentum gravida sagittis. Nullam sagittis, nibh vitae aliquam gravida, massa nibh rutrum metus, in pellentesque nibh quam nec turpis. Maecenas vulputate augue lorem. Etiam tristique leo ex, id pharetra odio posuere eget. Pellentesque neque nisl, consequat ac suscipit quis, mattis bibendum ante. Morbi faucibus neque vitae aliquet luctus. Nam nec turpis nec sapien scelerisque interdum. Mauris vitae consectetur nulla. Praesent tortor nisl, aliquam ultricies lacinia et, egestas id justo. Sed at odio vitae purus vestibulum pretium sed ac purus. Morbi quis dolor nulla. Integer suscipit, erat quis luctus pulvinar, nibh nunc faucibus sapien, commodo interdum ex nisl eget leo. Cras in purus sed velit ultrices ullamcorper vel sit amet dui. Vestibulum ut elit vitae nibh posuere consectetur et ac elit. Aenean risus magna, vulputate ac sagittis vel, mollis in velit. Fusce tortor libero, sodales fringilla consequat ut, volutpat eget orci. Vestibulum eget ex eu ante mollis ultricies vel quis dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus non sem a arcu fermentum dapibus. Suspendisse orci augue, sodales a luctus a, facilisis eget nibh. Sed id efficitur tortor, ut ullamcorper nunc. Duis neque augue, aliquet et leo aliquam, ullamcorper sodales neque. Pellentesque malesuada volutpat neque nec finibus. Sed tincidunt pretium ultricies. Duis scelerisque tincidunt faucibus. Suspendisse et iaculis ex. In efficitur eros metus, in semper ipsum ultrices a. Nulla dapibus est ut lacus mattis, at gravida orci semper. Pellentesque eu velit vel ante bibendum pharetra. Curabitur porttitor erat.');
INSERT INTO post (post_author, post_title, post_summary, post_content) VALUES (1, 'Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fermentum gravida sagittis. Nullam sagittis, nibh vitae aliquam gravida, massa nibh rutrum metus, in pellentesque nibh quam nec turpis. Maecenas vulputate augue lorem. Etiam tristique leo ex, id pharetra odio posuere eget. Pellentesque neque nisl, consequat ac suscipit quis, mattis bibendum ante. Morbi faucibus neque vitae aliquet luctus. Nam nec turpis nec sapien scelerisque interdum. Mauris vitae consectetur nulla. Praesent tortor nisl, aliquam ultricies lacinia et, egestas id justo. Sed at odio vitae purus vestibulum pretium sed ac purus. Morbi quis dolor nulla. Integer suscipit, erat quis luctus pulvinar, nibh nunc faucibus sapien, commodo interdum ex nisl eget leo. Cras in purus sed velit ultrices ullamcorper vel sit amet dui. Vestibulum ut elit vitae nibh posuere consectetur et ac elit. Aenean risus magna, vulputate ac sagittis vel, mollis in velit. Fusce tortor libero, sodales fringilla consequat ut, volutpat eget orci. Vestibulum eget ex eu ante mollis ultricies vel quis dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus non sem a arcu fermentum dapibus. Suspendisse orci augue, sodales a luctus a, facilisis eget nibh. Sed id efficitur tortor, ut ullamcorper nunc. Duis neque augue, aliquet et leo aliquam, ullamcorper sodales neque. Pellentesque malesuada volutpat neque nec finibus. Sed tincidunt pretium ultricies. Duis scelerisque tincidunt faucibus. Suspendisse et iaculis ex. In efficitur eros metus, in semper ipsum ultrices a. Nulla dapibus est ut lacus mattis, at gravida orci semper. Pellentesque eu velit vel ante bibendum pharetra. Curabitur porttitor erat.');
INSERT INTO post (post_author, post_title, post_summary, post_content) VALUES (1, 'Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fermentum gravida sagittis. Nullam sagittis, nibh vitae aliquam gravida, massa nibh rutrum metus, in pellentesque nibh quam nec turpis. Maecenas vulputate augue lorem. Etiam tristique leo ex, id pharetra odio posuere eget. Pellentesque neque nisl, consequat ac suscipit quis, mattis bibendum ante. Morbi faucibus neque vitae aliquet luctus. Nam nec turpis nec sapien scelerisque interdum. Mauris vitae consectetur nulla. Praesent tortor nisl, aliquam ultricies lacinia et, egestas id justo. Sed at odio vitae purus vestibulum pretium sed ac purus. Morbi quis dolor nulla. Integer suscipit, erat quis luctus pulvinar, nibh nunc faucibus sapien, commodo interdum ex nisl eget leo. Cras in purus sed velit ultrices ullamcorper vel sit amet dui. Vestibulum ut elit vitae nibh posuere consectetur et ac elit. Aenean risus magna, vulputate ac sagittis vel, mollis in velit. Fusce tortor libero, sodales fringilla consequat ut, volutpat eget orci. Vestibulum eget ex eu ante mollis ultricies vel quis dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus non sem a arcu fermentum dapibus. Suspendisse orci augue, sodales a luctus a, facilisis eget nibh. Sed id efficitur tortor, ut ullamcorper nunc. Duis neque augue, aliquet et leo aliquam, ullamcorper sodales neque. Pellentesque malesuada volutpat neque nec finibus. Sed tincidunt pretium ultricies. Duis scelerisque tincidunt faucibus. Suspendisse et iaculis ex. In efficitur eros metus, in semper ipsum ultrices a. Nulla dapibus est ut lacus mattis, at gravida orci semper. Pellentesque eu velit vel ante bibendum pharetra. Curabitur porttitor erat.');
INSERT INTO post (post_author, post_title, post_summary, post_content) VALUES (1, 'Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fermentum gravida sagittis. Nullam sagittis, nibh vitae aliquam gravida, massa nibh rutrum metus, in pellentesque nibh quam nec turpis. Maecenas vulputate augue lorem. Etiam tristique leo ex, id pharetra odio posuere eget. Pellentesque neque nisl, consequat ac suscipit quis, mattis bibendum ante. Morbi faucibus neque vitae aliquet luctus. Nam nec turpis nec sapien scelerisque interdum. Mauris vitae consectetur nulla. Praesent tortor nisl, aliquam ultricies lacinia et, egestas id justo. Sed at odio vitae purus vestibulum pretium sed ac purus. Morbi quis dolor nulla. Integer suscipit, erat quis luctus pulvinar, nibh nunc faucibus sapien, commodo interdum ex nisl eget leo. Cras in purus sed velit ultrices ullamcorper vel sit amet dui. Vestibulum ut elit vitae nibh posuere consectetur et ac elit. Aenean risus magna, vulputate ac sagittis vel, mollis in velit. Fusce tortor libero, sodales fringilla consequat ut, volutpat eget orci. Vestibulum eget ex eu ante mollis ultricies vel quis dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus non sem a arcu fermentum dapibus. Suspendisse orci augue, sodales a luctus a, facilisis eget nibh. Sed id efficitur tortor, ut ullamcorper nunc. Duis neque augue, aliquet et leo aliquam, ullamcorper sodales neque. Pellentesque malesuada volutpat neque nec finibus. Sed tincidunt pretium ultricies. Duis scelerisque tincidunt faucibus. Suspendisse et iaculis ex. In efficitur eros metus, in semper ipsum ultrices a. Nulla dapibus est ut lacus mattis, at gravida orci semper. Pellentesque eu velit vel ante bibendum pharetra. Curabitur porttitor erat.');
INSERT INTO post (post_author, post_title, post_summary, post_content) VALUES (1, 'Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fermentum gravida sagittis. Nullam sagittis, nibh vitae aliquam gravida, massa nibh rutrum metus, in pellentesque nibh quam nec turpis. Maecenas vulputate augue lorem. Etiam tristique leo ex, id pharetra odio posuere eget. Pellentesque neque nisl, consequat ac suscipit quis, mattis bibendum ante. Morbi faucibus neque vitae aliquet luctus. Nam nec turpis nec sapien scelerisque interdum. Mauris vitae consectetur nulla. Praesent tortor nisl, aliquam ultricies lacinia et, egestas id justo. Sed at odio vitae purus vestibulum pretium sed ac purus. Morbi quis dolor nulla. Integer suscipit, erat quis luctus pulvinar, nibh nunc faucibus sapien, commodo interdum ex nisl eget leo. Cras in purus sed velit ultrices ullamcorper vel sit amet dui. Vestibulum ut elit vitae nibh posuere consectetur et ac elit. Aenean risus magna, vulputate ac sagittis vel, mollis in velit. Fusce tortor libero, sodales fringilla consequat ut, volutpat eget orci. Vestibulum eget ex eu ante mollis ultricies vel quis dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus non sem a arcu fermentum dapibus. Suspendisse orci augue, sodales a luctus a, facilisis eget nibh. Sed id efficitur tortor, ut ullamcorper nunc. Duis neque augue, aliquet et leo aliquam, ullamcorper sodales neque. Pellentesque malesuada volutpat neque nec finibus. Sed tincidunt pretium ultricies. Duis scelerisque tincidunt faucibus. Suspendisse et iaculis ex. In efficitur eros metus, in semper ipsum ultrices a. Nulla dapibus est ut lacus mattis, at gravida orci semper. Pellentesque eu velit vel ante bibendum pharetra. Curabitur porttitor erat.');
INSERT INTO post (post_author, post_title, post_summary, post_content) VALUES (1, 'Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fermentum gravida sagittis. Nullam sagittis, nibh vitae aliquam gravida, massa nibh rutrum metus, in pellentesque nibh quam nec turpis. Maecenas vulputate augue lorem. Etiam tristique leo ex, id pharetra odio posuere eget. Pellentesque neque nisl, consequat ac suscipit quis, mattis bibendum ante. Morbi faucibus neque vitae aliquet luctus. Nam nec turpis nec sapien scelerisque interdum. Mauris vitae consectetur nulla. Praesent tortor nisl, aliquam ultricies lacinia et, egestas id justo. Sed at odio vitae purus vestibulum pretium sed ac purus. Morbi quis dolor nulla. Integer suscipit, erat quis luctus pulvinar, nibh nunc faucibus sapien, commodo interdum ex nisl eget leo. Cras in purus sed velit ultrices ullamcorper vel sit amet dui. Vestibulum ut elit vitae nibh posuere consectetur et ac elit. Aenean risus magna, vulputate ac sagittis vel, mollis in velit. Fusce tortor libero, sodales fringilla consequat ut, volutpat eget orci. Vestibulum eget ex eu ante mollis ultricies vel quis dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus non sem a arcu fermentum dapibus. Suspendisse orci augue, sodales a luctus a, facilisis eget nibh. Sed id efficitur tortor, ut ullamcorper nunc. Duis neque augue, aliquet et leo aliquam, ullamcorper sodales neque. Pellentesque malesuada volutpat neque nec finibus. Sed tincidunt pretium ultricies. Duis scelerisque tincidunt faucibus. Suspendisse et iaculis ex. In efficitur eros metus, in semper ipsum ultrices a. Nulla dapibus est ut lacus mattis, at gravida orci semper. Pellentesque eu velit vel ante bibendum pharetra. Curabitur porttitor erat.');
INSERT INTO post (post_author, post_title, post_summary, post_content) VALUES (1, 'Lorem ipsum dolor', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fermentum gravida sagittis. Nullam sagittis, nibh vitae aliquam gravida, massa nibh rutrum metus, in pellentesque nibh quam nec turpis. Maecenas vulputate augue lorem. Etiam tristique leo ex, id pharetra odio posuere eget. Pellentesque neque nisl, consequat ac suscipit quis, mattis bibendum ante. Morbi faucibus neque vitae aliquet luctus. Nam nec turpis nec sapien scelerisque interdum. Mauris vitae consectetur nulla. Praesent tortor nisl, aliquam ultricies lacinia et, egestas id justo. Sed at odio vitae purus vestibulum pretium sed ac purus. Morbi quis dolor nulla. Integer suscipit, erat quis luctus pulvinar, nibh nunc faucibus sapien, commodo interdum ex nisl eget leo. Cras in purus sed velit ultrices ullamcorper vel sit amet dui. Vestibulum ut elit vitae nibh posuere consectetur et ac elit. Aenean risus magna, vulputate ac sagittis vel, mollis in velit. Fusce tortor libero, sodales fringilla consequat ut, volutpat eget orci. Vestibulum eget ex eu ante mollis ultricies vel quis dolor. Interdum et malesuada fames ac ante ipsum primis in faucibus. Vivamus non sem a arcu fermentum dapibus. Suspendisse orci augue, sodales a luctus a, facilisis eget nibh. Sed id efficitur tortor, ut ullamcorper nunc. Duis neque augue, aliquet et leo aliquam, ullamcorper sodales neque. Pellentesque malesuada volutpat neque nec finibus. Sed tincidunt pretium ultricies. Duis scelerisque tincidunt faucibus. Suspendisse et iaculis ex. In efficitur eros metus, in semper ipsum ultrices a. Nulla dapibus est ut lacus mattis, at gravida orci semper. Pellentesque eu velit vel ante bibendum pharetra. Curabitur porttitor erat.');

INSERT INTO comment (comment_content, author_id, post_id) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 2, 1);
INSERT INTO comment (comment_content, author_id, post_id) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 2, 1);
INSERT INTO comment (comment_content, author_id, post_id) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis dui, ornare non nibh vitae, efficitur fermentum ipsum. Vestibulum efficitur augue non diam lobortis, sollicitudin semper ex ornare. Nunc et hendrerit quam. Donec finibus dapibus gravida. Mauris vulputate nunc a dui tincidunt, sit amet viverra nisl condimentum. Donec hendrerit risus ante, at maximus sem maximus id. Maecenas auctor lorem metus, sed maximus sem volutpat quis. Ut fermentum malesuada neque. Integer sit amet ante nec velit', 2, 1);